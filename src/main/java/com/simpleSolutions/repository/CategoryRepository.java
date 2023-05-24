package com.simpleSolutions.repository;

import com.simpleSolutions.entity.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll();

    Category findByName(String name);

    Category save(Category category);
}
