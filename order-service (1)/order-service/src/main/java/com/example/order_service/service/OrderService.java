package com.example.order_service.service;

import com.example.order_service.dto.OrderDTO;

public interface OrderService {

    String saveOrder(OrderDTO orderDTO);
    OrderDTO getOrder(Long orderId);
}
