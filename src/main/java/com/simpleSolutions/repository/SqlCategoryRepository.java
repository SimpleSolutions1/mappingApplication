package com.simpleSolutions.repository;

import com.simpleSolutions.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
interface SqlCategoryRepository extends CategoryRepository,JpaRepository<Category, Integer> {

    @Query("Select c from Category c where c.name = :name")
    Category findByName(String name);
}
