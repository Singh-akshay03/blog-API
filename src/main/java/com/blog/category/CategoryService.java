package com.blog.category;

import com.blog.DTOs.CategoryDTO;
import com.blog.Exceptions.CategoryNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category=modelMapper.map(categoryDTO,Category.class);
        return modelMapper.map(categoryRepository.save(category),CategoryDTO.class);
    }

    @Override
    public CategoryDTO UpdateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId));
        Category updatedCategory=new Category();
        updatedCategory.setId(categoryId);
        if(categoryDTO.getCategoryTitle()!=null){
            updatedCategory.setCategoryTitle(categoryDTO.getCategoryTitle());
        }
        if(categoryDTO.getCategoryDescription()!=null){
            updatedCategory.setCategoryDescription(categoryDTO.getCategoryDescription());
        }

        return this.modelMapper.map(categoryRepository.save(updatedCategory),CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId));
        categoryRepository.delete(category);
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId));
        return this.modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll()
                .stream().map(category -> this.modelMapper.map(category,CategoryDTO.class))
                .toList();
    }
}
