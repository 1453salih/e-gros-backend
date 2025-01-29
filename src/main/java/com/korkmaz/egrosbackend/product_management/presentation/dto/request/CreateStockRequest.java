package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStockRequest {

    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    @Min(value = 0, message = "Reserved quantity cannot be negative")
    private Integer reservedQuantity;

    @NotBlank(message = "Updated by is required")
    private String updatedBy;
}