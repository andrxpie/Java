package org.example.mappers;

import org.example.DTOs.CategoryDto;
import org.example.entities.Category;
import org.example.DTOs.CategoryCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "image", ignore = true)
    Category fromCreationModel(CategoryCreateDto categoryModel);
    CategoryDto toDto(Category category);
    List<CategoryDto> toDto(Iterable<Category> category);
}