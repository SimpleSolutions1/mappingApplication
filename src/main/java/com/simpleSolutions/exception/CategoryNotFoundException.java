package com.simpleSolutions.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String categoryName) {
        super("Category with name: "+categoryName+" not found");
    }
}
