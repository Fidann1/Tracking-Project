package com.example.order_service.client;

import com.example.order_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service",url="${product.service.url}")
public interface ProductClient {

    @GetMapping()
    List<ProductDTO> getAllProducts();

    @GetMapping("/{id}")
    ProductDTO getProductById(@PathVariable Long id);

}
