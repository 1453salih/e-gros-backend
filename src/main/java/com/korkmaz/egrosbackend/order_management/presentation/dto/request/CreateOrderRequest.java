package com.korkmaz.egrosbackend.order_management.presentation.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class CreateOrderRequest {
    private Long customerId;
    private Long shippingId;
    private Long paymentId;
    private List<OrderItemDTO> items;

    @Data
    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;
    }
}