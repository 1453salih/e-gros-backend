package com.korkmaz.egrosbackend.order_management.domain.events;

import com.korkmaz.egrosbackend.order_management.application.dto.OrderItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderCreatedEvent {
    private String correlationId;
    private Long orderId;
    private Double totalPrice;
    private List<OrderItemDTO> items;
}