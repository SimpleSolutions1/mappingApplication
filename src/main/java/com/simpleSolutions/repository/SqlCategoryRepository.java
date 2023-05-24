package com.simpleSolutions.repository;

import com.simpleSolutions.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
interface SqlCategoryRepository extends CategoryRepository,JpaRepository<Category, Integer> {

    @Override
    @Query("Select c from Category c where c.name = :name")
    Category findByName(@Param("name") String name);
}
