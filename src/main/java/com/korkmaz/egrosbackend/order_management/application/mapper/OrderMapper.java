package com.korkmaz.egrosbackend.order_management.application.mapper;

import com.korkmaz.egrosbackend.order_management.domain.entity.Order;
import com.korkmaz.egrosbackend.order_management.domain.entity.OrderItem;
import com.korkmaz.egrosbackend.order_management.presentation.dto.request.CreateOrderRequest;
import com.korkmaz.egrosbackend.order_management.presentation.dto.response.OrderResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderDate", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "items", ignore = true)
    Order toEntity(CreateOrderRequest request);

    OrderResponse toResponse(Order order);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "unitPrice", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    OrderItem toOrderItem(CreateOrderRequest.OrderItemDTO request);
}