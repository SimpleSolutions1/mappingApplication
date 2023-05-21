package com.simpleSolutions.controller;

import com.simpleSolutions.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping(value = "/categories")
    ResponseEntity<?> readAllCategories(){
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping(value = "/category")
    ResponseEntity<?> findByName(@RequestParam("name") String name){

        return ResponseEntity.ok(categoryRepository.findByName(name));
    }

}
