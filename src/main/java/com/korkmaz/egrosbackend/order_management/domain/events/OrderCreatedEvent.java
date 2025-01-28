package com.korkmaz.egrosbackend.order_management.domain.events;

import com.korkmaz.egrosbackend.order_management.application.dto.OrderItemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderCreatedEvent {
    private String correlationId;
    private Long orderId;
    private Double totalPrice;
    private List<OrderItemDTO> items;
}