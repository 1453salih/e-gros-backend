package com.korkmaz.egrosbackend.product_management.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCatalogResponse {
    private Long id;
    private String barcode;
    private String sku;
    private BigDecimal salesPrice;
    private BigDecimal listPrice;
    private Boolean isActive;
    private List<CreateCatalogImageResponse> images;
    private Set<CreateCatalogAttributeResponse> variantAttributes;
}
