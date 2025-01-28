package com.korkmaz.egrosbackend.order_management.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private Long customerId;
    private Long shippingId;
    private Long paymentId;
    private LocalDateTime orderDate;
    private String status;
    private Double totalPrice;
    private List<OrderItemResponse> items;

    @Getter
@Setter
    public static class OrderItemResponse {
        private Long id;
        private Long productId;
        private Integer quantity;
        private Double unitPrice;
        private Double totalPrice;
    }
}