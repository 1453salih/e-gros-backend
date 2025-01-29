package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceRequest {

    @NotNull(message = "Product ID is required")
    private Long productId;
}
