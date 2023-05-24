package com.simpleSolutions.service;

import com.simpleSolutions.dto.MappingModelDTO;
import com.simpleSolutions.entity.Category;
import com.simpleSolutions.entity.Word;
import com.simpleSolutions.exception.CategoryNotFoundException;
import com.simpleSolutions.exception.OutOfRangeException;
import com.simpleSolutions.repository.CategoryRepository;
import com.simpleSolutions.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Primary
@AllArgsConstructor
public class MappingService implements DivisorMapping {
    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 20;
    private final WordRepository wordRepository;
    private final CategoryRepository categoryRepository;

    public Map<Integer, List<String>> getDivisorsMap(MappingModelDTO mappingModelDTO) {
        Map<Integer, List<String>> returnedMap = new HashMap<>();
        Optional<Category> category = Optional.ofNullable(categoryRepository.findByName(mappingModelDTO.getCategoryName()));
        if (!category.isPresent()) {
            throw new CategoryNotFoundException(mappingModelDTO.getCategoryName());
        }
        if (numberIsOutOfRange(mappingModelDTO.getNumberList())) {
            throw new OutOfRangeException(mappingModelDTO.getNumberList(), MAX_RANGE, MIN_RANGE);
        }
        Map<Integer, List<Integer>> findDivisorMap = findDivisors(mappingModelDTO.getNumberList());
        List<Integer> divisorsList = findDivisorMap.values().stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
        Map<Integer, String> wordMap = wordRepository.findByCategoryAndDivisorList(category.get().getId(), divisorsList).stream()
                .collect(Collectors.toMap(Word::getNumber, Word::getWord));

        findDivisorMap.entrySet().stream()
                .map(Map.Entry::getKey)
                .forEach(k -> {
                    mappingDividorsToWords(returnedMap, k, findDivisorMap, wordMap);
                });
        return returnedMap;
    }

    private void mappingDividorsToWords(Map<Integer, List<String>> returnedMap, Integer k, Map<Integer, List<Integer>> findDivisorMap, Map<Integer, String> wordMap) {
        List<String> wordList = new ArrayList<>();
        findDivisorMap.get(k).forEach(v -> wordList.add(wordMap.getOrDefault(v, null)));
        if (!returnedMap.values().stream().anyMatch(l -> l.equals(wordList.stream().filter(Objects::nonNull).toList()))) {
            returnedMap.put(k, wordList.stream().filter(Objects::nonNull).toList());
        }
    }

    private boolean numberIsOutOfRange(List<Integer> numbers) {
        Integer max = numbers.stream().max(Integer::compareTo).get();
        Integer min = numbers.stream().max(Integer::compareTo).get();
        return min < MIN_RANGE || max > MAX_RANGE;
    }

    private HashMap<Integer, List<Integer>> findDivisors(List<Integer> numbers) {
        HashMap<Integer, List<Integer>> dividorsMap = new HashMap<>();
        numbers.stream().distinct().forEach(
                number -> {
                    IntStream.range(1, number + 1)
                            .filter(divisor -> number % divisor == 0)
                            .forEach(divisor -> dividorsMap.computeIfAbsent(number, k -> new ArrayList<>()).add(divisor));
                }
        );
        return dividorsMap;
    }

}
