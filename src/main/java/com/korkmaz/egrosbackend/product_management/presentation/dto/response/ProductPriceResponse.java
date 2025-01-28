package com.korkmaz.egrosbackend.product_management.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceResponse {
    private Long productId;
    private String productName;
    private BigDecimal salesPrice;
    private BigDecimal listPrice;
    private Boolean isActive;
}