package com.blog.Exceptions;

public class CategoryNotFoundException  extends RuntimeException{

    String message;
    public CategoryNotFoundException(Long categoryId) {
        super("Category with category Id: "+categoryId+" not found");
        this.message="Category with category Id: "+categoryId+" not found";
    }
}
