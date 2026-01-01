package com.example.order_service.controller;

import com.example.order_service.dto.OrderDTO;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderService.saveOrder(orderDTO), HttpStatus.CREATED);

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long orderId) {
        return  new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }

}
