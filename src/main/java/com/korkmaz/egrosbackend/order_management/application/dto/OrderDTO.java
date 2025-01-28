package com.korkmaz.egrosbackend.order_management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Long customerId;
    private Long shippingId;
    private Long paymentId;
    private LocalDateTime orderDate;
    private String status;
    private Double totalPrice;
    private List<OrderItemDTO> items;
}