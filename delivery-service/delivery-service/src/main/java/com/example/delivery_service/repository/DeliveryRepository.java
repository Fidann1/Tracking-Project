package com.example.delivery_service.repository;

import com.example.delivery_service.entity.DeliveryEntity;
import com.example.delivery_service.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {

   Optional<DeliveryEntity> findByOrderId(UUID orderId);

   @Modifying
   @Transactional
   @Query("UPDATE DeliveryEntity d " +
           "SET d.status= :newStatus " +
           "WHERE d.status= :currentStatus " +
           "AND d.createdAt <= :threshold")
   void updateStatus(@Param("currentStatus")StatusEnum currentStatus,
                     @Param("newStatus") StatusEnum newStatus ,
                     @Param("threshold") LocalDateTime threshold);
}
