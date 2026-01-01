package com.example.order_service.service.impl;

import com.example.order_service.client.ProductClient;
import com.example.order_service.dto.OrderDTO;
import com.example.order_service.dto.ProductDTO;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.kafka.OrderEvent;
import com.example.order_service.mapper.OrderMapper;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final  OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private final  NewTopic topic;

    @Override
    @Transactional
    public String saveOrder(OrderDTO orderDTO) {
        try{ ProductDTO productDTO= productClient.getProductById(orderDTO.getProductId());
            if(productDTO != null && productDTO.getStock()>=orderDTO.getQuantity()){
               OrderEntity orderEntity= orderRepository.save(orderMapper.toOrderEntity(orderDTO));
                OrderEvent orderEvent= OrderEvent.builder()
                        .productId(orderDTO.getProductId())
                        .quantity(orderDTO.getQuantity())
                        .orderId(orderEntity.getOrderId())
                        .build();
                kafkaTemplate.send(topic.name(), orderEvent);

                return "Order added successfully";
            }
            return "Order not added";
        }
        catch (Exception e){
            return "Order not added";
        }
    }

    @Override
    public OrderDTO getOrder(Long orderId) {
        return orderMapper.toOrderDTO(orderRepository.findById(orderId).get());
    }
}
