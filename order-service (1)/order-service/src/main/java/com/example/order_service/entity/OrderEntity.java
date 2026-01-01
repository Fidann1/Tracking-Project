package com.example.order_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    private UUID orderId;
    private Long productId;
    private Long quantity;
}
