package com.example.delivery_service.dto;

import com.example.delivery_service.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class DeliveryDTO {
    private UUID orderId;
    private StatusEnum status;
    private LocalDateTime estimatedDeliveryTime;

}
