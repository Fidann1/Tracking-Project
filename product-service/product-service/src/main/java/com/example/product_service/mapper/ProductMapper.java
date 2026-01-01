package com.example.product_service.mapper;

import com.example.product_service.dto.ProductDTO;
import com.example.product_service.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToProductDTO(ProductEntity product);
}
