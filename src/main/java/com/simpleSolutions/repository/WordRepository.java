package com.simpleSolutions.repository;

import com.simpleSolutions.entity.Word;

import java.util.List;

public interface WordRepository {
    List<Word> findAll();

    List<Word> findByCategoryAndDivisorList(Integer categoryId,List<Integer> numberList);
}
