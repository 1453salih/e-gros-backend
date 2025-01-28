package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

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
    private String barcode;
    private String sku;
    private BigDecimal salesPrice;
    private BigDecimal listPrice;

    private Boolean isActive;
    private CreateStockRequest stock;
    private List<CreateCatalogImageRequest> images;
    private Set<CreateCatalogAttributeRequest> variantAttributes;
}
