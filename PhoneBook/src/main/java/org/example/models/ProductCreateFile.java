package org.example.models;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductCreateFile {
    private MultipartFile file;
    private int priority;
}