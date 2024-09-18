package org.example.mappers;

import org.example.DTOs.ProductImageDto;
import org.example.entities.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductImageMapper {
    @Mapping(target = "productId", source = "product.id")
    ProductImageDto toDto(ProductImage image);
    List<ProductImageDto> toDto(Iterable<ProductImage> product);
}