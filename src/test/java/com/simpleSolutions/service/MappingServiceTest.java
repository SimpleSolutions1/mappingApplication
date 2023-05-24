package com.simpleSolutions.service;

import com.simpleSolutions.dto.MappingModelDTO;
import com.simpleSolutions.entity.Category;
import com.simpleSolutions.exception.CategoryNotFoundException;
import com.simpleSolutions.exception.OutOfRangeException;
import com.simpleSolutions.repository.CategoryRepository;
import com.simpleSolutions.repository.WordRepository;
import com.simpleSolutions.service.MappingService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class MappingServiceTest {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    WordRepository wordRepository;

    @Test
    @DisplayName("should throw CategoryNotFoundException when not found category")
    void getDivisorsMap_throwsCategoryNotFoundException() {
        //give
        var mappingService = new MappingService(wordRepository, categoryRepository);
        MappingModelDTO mappingModelDTO = new MappingModelDTO(anyString(), List.of());
        // when
        var exception = catchThrowable(() -> mappingService.getDivisorsMap(mappingModelDTO));
        // then
        assertThat(exception)
                .isInstanceOf(CategoryNotFoundException.class)
                .hasMessageContaining("not found");
    }

    @Test
    @DisplayName("should throw OutOfRangeException when numbers is out of range")
    void getDivisorsMap_throwsOutOfRangeException() throws NoSuchFieldException {
        //given
        var mappingService = new MappingService(wordRepository, categoryRepository);
        Category category = categoryRepository.findByName("Animals");
        MappingModelDTO mappingModelDTO = new MappingModelDTO(category.getName(), List.of(0, 50));
        // when
        var exception = catchThrowable(() -> mappingService.getDivisorsMap(mappingModelDTO));
        // then
        assertThat(exception)
                .isInstanceOf(OutOfRangeException.class)
                .hasMessageContaining("greather then");
    }

    @Test
    @DisplayName("should return simple map od divisor when numbers is out of range")
    void getDivisorsMap_simpleDivisorMap() {
        //given
        var mappingService = new MappingService(wordRepository, categoryRepository);
        MappingModelDTO mappingModelDTO = new MappingModelDTO("Animals", List.of(1,2,4,10));

        Map<Integer, List<String>> dividorsMap = mappingService.getDivisorsMap(mappingModelDTO);
        // then
        Map<Integer, List<String>> response = new HashMap<>();
        response.put(1,List.of("Mouse"));
        response.put(2,List.of("Mouse","Cat"));
        response.put(4,List.of("Mouse","Cat","Elephant"));
        assertTrue(response.toString().equals(dividorsMap.toString()));
    }

}

