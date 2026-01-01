package com.example.product_service.service.impl;

import com.example.product_service.dto.ProductDTO;
import com.example.product_service.entity.ProductEntity;
import com.example.product_service.exception.ProductDoesNotExist;
import com.example.product_service.kafka.OrderEvent;
import com.example.product_service.mapper.ProductMapper;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(productMapper ::productToProductDTO).toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::productToProductDTO)
                .orElseThrow(ProductDoesNotExist::new);
    }

    @KafkaListener(topics="${app.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")
    public void listen(OrderEvent orderEvent){
        ProductEntity product=productRepository.findById(orderEvent.getProductId()).orElseThrow(ProductDoesNotExist::new);
        product.setStock(product.getStock() - orderEvent.getQuantity());
        productRepository.save(product);
    }
}
