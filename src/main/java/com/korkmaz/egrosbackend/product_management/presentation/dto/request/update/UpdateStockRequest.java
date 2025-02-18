package com.korkmaz.egrosbackend.product_management.presentation.dto.request.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStockRequest {
    private Integer quantity;
    private Integer reservedQuantity;
    private String updatedBy;
}
