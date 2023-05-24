package com.simpleSolutions.controller;

import com.simpleSolutions.repository.WordRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class WordController {
    private final WordRepository wordRepository;

    @GetMapping(value = "/words")
    ResponseEntity<?> readAllWords() {
        return ResponseEntity.ok(wordRepository.findAll());
    }
}
