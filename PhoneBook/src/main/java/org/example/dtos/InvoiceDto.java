package org.example.dtos;

import lombok.Data;

@Data
public class InvoiceDto {
    private Long id;
    private String name;
    private String location;
    private String image;
    private Double amount;
}