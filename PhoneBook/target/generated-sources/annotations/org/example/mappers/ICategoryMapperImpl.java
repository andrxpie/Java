package org.example.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.DTOs.CategoryCreateDto;
import org.example.DTOs.CategoryDto;
import org.example.entities.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-18T18:58:21+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ICategoryMapperImpl implements ICategoryMapper {

    @Override
    public Category fromCreationModel(CategoryCreateDto categoryModel) {
        if ( categoryModel == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryModel.getId() );
        category.setName( categoryModel.getName() );
        category.setDescription( categoryModel.getDescription() );

        return category;
    }

    @Override
    public CategoryDto toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setImage( category.getImage() );
        categoryDto.setDescription( category.getDescription() );
        categoryDto.setCreationTime( category.getCreationTime() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> toDto(Iterable<Category> category) {
        if ( category == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>();
        for ( Category category1 : category ) {
            list.add( toDto( category1 ) );
        }

        return list;
    }
}
