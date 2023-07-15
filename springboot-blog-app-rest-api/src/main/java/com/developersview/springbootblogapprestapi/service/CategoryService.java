package com.developersview.springbootblogapprestapi.service;

import com.developersview.springbootblogapprestapi.entity.Category;
import com.developersview.springbootblogapprestapi.payload.CategoryDto;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 16/07/2023
 */
public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto getCategory(Long categoryId);
    List<CategoryDto> getALlCategories();
    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
    void deleteCategory(Long categoryId);

}
