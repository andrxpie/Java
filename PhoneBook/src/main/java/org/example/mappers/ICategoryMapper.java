package org.example.mappers;

import org.example.dtos.CategoryDto;
import org.example.entities.Category;
import org.example.dtos.CategoryCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    @Mapping(target = "image", ignore = true)
    Category fromCreationModel(CategoryCreateDto categoryModel);
    CategoryDto toDto(Category category);
    List<CategoryDto> toDto(Iterable<Category> category);
}