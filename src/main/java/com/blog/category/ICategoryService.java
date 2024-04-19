package com.blog.category;

import com.blog.DTOs.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    // CREATE CATEGORY

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    //UPDATE CATEGORY
    CategoryDTO UpdateCategory(CategoryDTO categoryDTO,Long categoryId);

    //DELETE CATEGORY
    void deleteCategory(Long categoryId);

    //GET CATEGORY BY ID
    CategoryDTO getCategoryById(Long categoryId);

    //GET ALL CATEGORY
    List<CategoryDTO> getAllCategory();
}
