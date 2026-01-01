package com.example.order_service.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Double price;
    private Long stock;
}
