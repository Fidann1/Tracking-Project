package com.example.product_service.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String name;
    private Double price;
    private Long stock;
}
