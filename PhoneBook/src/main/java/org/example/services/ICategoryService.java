package org.example.services;

import org.example.DTOs.CategoryDto;
import org.example.DTOs.CategoryResponse;
import org.example.DTOs.CategoryCreateDto;

import java.io.IOException;

public interface ICategoryService {
    public Integer saveCategory(CategoryCreateDto model);
    CategoryResponse getCategoryByName(int page, int size, String name);
    public CategoryDto getCategoryById(Integer id);
    public boolean deleteCategoryById(Integer id) throws IOException;
    boolean updateCategory(CategoryCreateDto categoryModel) throws IOException;
}