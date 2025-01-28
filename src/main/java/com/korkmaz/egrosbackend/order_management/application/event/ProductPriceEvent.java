package com.korkmaz.egrosbackend.order_management.application.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceEvent {
    private Long orderId;
    private Long productId;
    private Double price;
}