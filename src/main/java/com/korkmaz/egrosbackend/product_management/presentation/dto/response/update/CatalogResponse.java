package com.korkmaz.egrosbackend.product_management.presentation.dto.response.update;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CatalogResponse {
    private Long id;
    private String barcode;
    private String sku;
    private BigDecimal salesPrice;
    private BigDecimal listPrice;
    private Boolean isActive;
    private List<CatalogImageResponse> images;
    private Set<CatalogAttributeResponse> variantAttributes;
    private StockResponse stock;
}