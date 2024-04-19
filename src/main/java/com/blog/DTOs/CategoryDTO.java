package com.blog.DTOs;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String categoryTitle;
    private String categoryDescription;
}
