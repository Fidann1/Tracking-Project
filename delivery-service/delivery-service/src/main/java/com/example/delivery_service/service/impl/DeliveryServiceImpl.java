package com.example.delivery_service.service.impl;

import com.example.delivery_service.dto.DeliveryDTO;
import com.example.delivery_service.entity.DeliveryEntity;
import com.example.delivery_service.enums.StatusEnum;
import com.example.delivery_service.exception.DeliveryNotFound;
import com.example.delivery_service.kafka.OrderEvent;
import com.example.delivery_service.mapper.DeliveryMapper;
import com.example.delivery_service.repository.DeliveryRepository;
import com.example.delivery_service.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;


    @Override
    public DeliveryDTO getDelivery(UUID orderId) {
        DeliveryEntity deliveryEntity = deliveryRepository.findByOrderId(orderId).orElseThrow(DeliveryNotFound::new);
        return deliveryMapper.toDeliveryDTO(deliveryEntity);
    }

    @KafkaListener(topics = "${app.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")
    private void createDelivery( OrderEvent orderEvent){
        DeliveryEntity deliveryEntity= DeliveryEntity.builder()
                .estimatedDeliveryTime(LocalDateTime.now().plusDays(5))
                .orderId(orderEvent.getOrderId())  //should be changed
                .status(StatusEnum.CREATED)
                .build();

        deliveryRepository.save(deliveryEntity);
    }


}
