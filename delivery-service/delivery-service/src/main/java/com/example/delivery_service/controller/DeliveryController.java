package com.example.delivery_service.controller;

import com.example.delivery_service.dto.DeliveryDTO;
import com.example.delivery_service.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping("/{orderId}")
    public ResponseEntity<DeliveryDTO> getDelivery(@PathVariable UUID orderId) {

        return ResponseEntity.ok(deliveryService.getDelivery(orderId));
    }

}
