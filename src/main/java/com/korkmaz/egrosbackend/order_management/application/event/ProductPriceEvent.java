package com.korkmaz.egrosbackend.order_management.application.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceEvent {
    private Long orderId;
    private Long productId;
    private Double price;
}