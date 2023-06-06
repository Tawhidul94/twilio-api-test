package com.test.service;

import com.test.entity.Definition;
import com.test.repository.DictionaryRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryService {

    public static final String ACCOUNT_SID = "AC1a0855ed64de01462b7832acd7dbd58f";
    public static final String AUTH_TOKEN = "329a7d5d70b9809683e4ca3448138457";
    private final DictionaryRepository repository;




    public void sendReply(String from, String to, String text) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        List<Definition> defs = repository.findByName(text)
                .orElseThrow(() -> new IllegalStateException("No item found"));
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(from),
                        new com.twilio.type.PhoneNumber(to),
                        defs.toString())
                .create();

        System.out.println(defs);
    }
}
