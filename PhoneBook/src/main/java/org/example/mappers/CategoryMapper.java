package org.example.mappers;

import org.example.DTOs.CategoryDto;
import org.example.entities.Category;
import org.example.DTOs.CategoryCreateDto;
import org.mapstruct.Mapping;

public interface CategoryMapper {
    @Mapping(target = "image", ignore = true)
    Category fromCategoryCreateDto(CategoryCreateDto category);
    CategoryDto toDto(Category category);
    Iterable<CategoryDto> toDto(Iterable<Category> category);
}