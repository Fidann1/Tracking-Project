package com.example.order_service.mapper;

import com.example.order_service.dto.OrderDTO;
import com.example.order_service.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity toOrderEntity(OrderDTO order);

    OrderDTO toOrderDTO(OrderEntity order);
}
