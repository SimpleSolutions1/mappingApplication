package com.simpleSolutions.controller;

import com.simpleSolutions.entity.Category;
import com.simpleSolutions.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void httpGet_returnsAllCategories() {
        // given
        int initial = categoryRepository.findAll().size();
        Category category = new Category();
        category.setName("Flowers");
        categoryRepository.save(category);

        // when
        Category[] result = restTemplate.getForObject("http://localhost:" + port + "/categories", Category[].class);

        // then
        assertThat(result).hasSize(initial + 1);
    }
}
