package com.example.delivery_service.scheduler;

import com.example.delivery_service.enums.StatusEnum;
import com.example.delivery_service.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeliveryScheduler {

    private final DeliveryRepository deliveryRepository;

    @Scheduled(fixedRate = 10000)
    public void scheduleDelivery() {
        LocalDateTime threshold= LocalDateTime.now().minusSeconds(30);
        deliveryRepository.updateStatus(StatusEnum.CREATED, StatusEnum.IN_PROGRESS,threshold);

    }
}
