package com.simpleSolutions.controller;

import com.simpleSolutions.dto.WordRequestModelDTO;
import com.simpleSolutions.entity.Word;
import com.simpleSolutions.repository.WordRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class WordController {
    private final WordRepository wordRepository;

    @GetMapping(value = "/words")
    ResponseEntity<?> readAllWords() {
        return ResponseEntity.ok(wordRepository.findAll());
    }

    @GetMapping(value = "/word")
    ResponseEntity<?> findByCategoryAndDivisorList(@RequestBody @Valid WordRequestModelDTO wordRequestModelDTO) {
        return null;
    }
}
