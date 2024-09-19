package org.example.interfaces;

import org.example.dtos.CategoryDto;
import org.example.models.CategoryCreateDto;
import org.example.models.PaginationResponse;
import java.io.IOException;

public interface ICategoryService {
    Long saveCategory(CategoryCreateDto categoryModel);
    PaginationResponse<CategoryDto> getCategoryByName(int page, int size, String name) ;
    PaginationResponse<CategoryDto> getCategories(int page,int size);
    CategoryDto getCategoryById(Long id);
    boolean deleteCategoryById(Long id) throws IOException;
    boolean updateCategory(CategoryCreateDto categoryModel) throws IOException;
}