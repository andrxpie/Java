package org.example.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResponse {
    private Iterable<CategoryDto> categoryList;
    private long totalElements;
}