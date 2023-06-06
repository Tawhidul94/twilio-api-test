package com.test.controller;

import com.test.service.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dictionary")
@AllArgsConstructor
public class DictionaryController {

    private final DictionaryService service;

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void getMessage(@RequestParam("From") String From, @RequestParam("To") String To, @RequestParam("Body") String Body) {
        System.out.println("From: " + From + " To: " + To + " Message: " + Body);
        service.sendReply(From, To, Body);
    }
}
