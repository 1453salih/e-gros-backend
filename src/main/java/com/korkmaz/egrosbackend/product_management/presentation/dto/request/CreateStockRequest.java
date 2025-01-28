package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStockRequest {
    private Integer quantity;
    private Integer reservedQuantity;
    private String updatedBy;
}