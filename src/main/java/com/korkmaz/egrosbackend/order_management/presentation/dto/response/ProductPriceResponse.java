package com.korkmaz.egrosbackend.order_management.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceResponse {
    private Long productId;
    private Double price;
    private String productName;
}