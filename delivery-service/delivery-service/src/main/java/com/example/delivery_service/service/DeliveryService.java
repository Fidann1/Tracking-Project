package com.example.delivery_service.service;

import com.example.delivery_service.dto.DeliveryDTO;

import java.util.UUID;

public interface DeliveryService {
    DeliveryDTO getDelivery(UUID orderId);
}
