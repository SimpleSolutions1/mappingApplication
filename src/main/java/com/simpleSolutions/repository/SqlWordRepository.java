package com.simpleSolutions.repository;

import com.simpleSolutions.entity.Word;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SqlWordRepository extends WordRepository, JpaRepository<Word, Integer> {

    @Override
    @Query("Select w from Word w where w.category.id = :categoryId and w.number in (:numberList)")
    List<Word> findByCategoryAndDivisorList(@Param("categoryId") Integer categoryId, @Param("numberList") List<Integer> numberList);
}
