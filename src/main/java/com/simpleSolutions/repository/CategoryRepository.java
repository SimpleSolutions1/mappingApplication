package com.simpleSolutions.repository;

import com.simpleSolutions.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {


    List<Category> findAll();

    Category findByName(String name);

    Category saveAndFlush(Category category);
}
