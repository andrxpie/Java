package org.example.DTOs;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CategoryCreateDto {
    private int id;
    private String name;
    private MultipartFile file;
    private String description;
}