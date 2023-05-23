package com.simpleSolutions.controller;

import com.simpleSolutions.entity.Category;
import com.simpleSolutions.exception.CategoryNotFoundException;
import com.simpleSolutions.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping(value = "/categories")
    ResponseEntity<?> readAllCategories() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping(value = "/category")
    ResponseEntity<?> findByName(@RequestParam("name") String name) {
        Optional<Category> category = Optional.of(categoryRepository.findByName(name));
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
