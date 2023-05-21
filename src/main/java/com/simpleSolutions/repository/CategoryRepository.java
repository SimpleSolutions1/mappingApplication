package com.simpleSolutions.repository;

import com.simpleSolutions.entity.Category;

import java.util.List;

public interface CategoryRepository {

    Category getReferenceById(Integer integer);

    List<Category> findAll();

    Category findByName(String name);
}
