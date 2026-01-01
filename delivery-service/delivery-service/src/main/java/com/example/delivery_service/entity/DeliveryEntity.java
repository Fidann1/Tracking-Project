package com.example.delivery_service.entity;

import com.example.delivery_service.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="deliveries")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private UUID orderId;
    private StatusEnum status;
    private LocalDateTime estimatedDeliveryTime;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
