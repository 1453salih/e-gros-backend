package com.korkmaz.egrosbackend.order_management.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {
    private Long customerId;
    private Long shippingId;
    private Long paymentId;
    private List<OrderItemDTO> items;

    @Getter
@Setter
    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;
    }
}