package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogRequest {
    @NotBlank(message = "Barcode is required")
    @Size(max = 50, message = "Barcode cannot exceed 50 characters")
    private String barcode;

    @NotBlank(message = "SKU is required")
    @Size(max = 50, message = "SKU cannot exceed 50 characters")
    private String sku;

    @NotNull(message = "Sales price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Sales price must be greater than 0")
    private BigDecimal salesPrice;

    @NotNull(message = "List price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "List price must be greater than 0")
    private BigDecimal listPrice;


    private Boolean isActive = true;

    @Valid
    private CreateStockRequest stock;

    @Valid
    private List<CreateCatalogImageRequest> images;

    @Valid
    private Set<CreateCatalogAttributeRequest> variantAttributes;
}
