package org.example.interfaces;

import org.example.dtos.CategoryDto;
import org.example.dtos.CategoryCreateDto;
import org.example.dtos.PaginationResponse;
import java.io.IOException;

public interface ICategoryService {
    Long saveCategory(CategoryCreateDto categoryModel);
    PaginationResponse<CategoryDto> getCategoryByName(int page, int size, String name) ;
    PaginationResponse<CategoryDto> getCategories(int page,int size);
    CategoryDto getCategoryById(Long id);
    boolean deleteCategoryById(Long id) throws IOException;
    boolean updateCategory(CategoryCreateDto categoryModel) throws IOException;
}