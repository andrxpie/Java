package org.example.services;

import org.example.DTOs.CategoryDto;
import org.example.DTOs.CategoryCreateDto;
import org.example.DTOs.PaginationResponse;
import java.io.IOException;

public interface ICategoryService {
    Long saveCategory(CategoryCreateDto categoryModel);
    PaginationResponse<CategoryDto> getCategoryByName(int page, int size, String name) ;
    PaginationResponse<CategoryDto> getCategories(int page,int size);
    CategoryDto getCategoryById(Long id);
    boolean deleteCategoryById(Long id) throws IOException;
    boolean updateCategory(CategoryCreateDto categoryModel) throws IOException;
}