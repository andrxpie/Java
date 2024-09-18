package org.example.DTOs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDto{
    private Long id;
    private String name;
    private String description;
    private double price;
    private double discount;
    private Long categoryId;
    private MultipartFile[] files;
}