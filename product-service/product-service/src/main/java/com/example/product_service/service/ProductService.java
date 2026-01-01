package com.example.product_service.service;

import com.example.product_service.dto.ProductDTO;

import java.util.List;

public interface  ProductService {

   List<ProductDTO> getProducts();
   ProductDTO getProductById(Long id);
}
