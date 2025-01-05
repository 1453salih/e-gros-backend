package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogRequest {
    private String barcode;
    private String sku;
    private BigDecimal salesPrice;
    private BigDecimal listPrice;
    private Integer stockQuantity;
    private Boolean isActive;
    private List<CreateCatalogImageRequest> images;
    private Set<CreateCatalogAttributeRequest> variantAttributes;
}
