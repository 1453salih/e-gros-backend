package com.korkmaz.egrosbackend.order_management.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceResponse {
    private Long productId;
    private Double price;
    private String productName;
}