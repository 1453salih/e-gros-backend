package com.korkmaz.egrosbackend.product_management.presentation.dto.response.update;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StockResponse {
    private Long id;
    private Integer quantity;
    private Integer reservedQuantity;
    private Integer availableQuantity;
    private LocalDateTime lastUpdated;
    private String updatedBy;
}