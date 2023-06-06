package com.test.repository;

import com.test.entity.Definition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DictionaryRepository extends JpaRepository<Definition, String> {

    Optional<List<Definition>> findByName(String name);
}
