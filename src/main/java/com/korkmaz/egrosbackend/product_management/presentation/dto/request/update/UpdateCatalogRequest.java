package com.korkmaz.egrosbackend.product_management.presentation.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCatalogRequest {
    private String barcode;
    private String sku;
    private BigDecimal salesPrice;
    private BigDecimal listPrice;
    private Boolean isActive;
}