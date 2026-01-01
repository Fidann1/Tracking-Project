package com.example.delivery_service.mapper;

import com.example.delivery_service.dto.DeliveryDTO;
import com.example.delivery_service.entity.DeliveryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

     DeliveryDTO toDeliveryDTO(DeliveryEntity deliveryEntity);
     DeliveryEntity toDeliveryEntity(DeliveryDTO deliveryDTO);
}
