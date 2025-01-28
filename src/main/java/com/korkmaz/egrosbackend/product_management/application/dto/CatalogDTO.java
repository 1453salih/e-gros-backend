package com.korkmaz.egrosbackend.product_management.application.dto;

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
public class CatalogDTO {
    private Long id;
    private Long productId;
    private String barcode;
    private String sku;
    private BigDecimal salesPrice;
    private BigDecimal listPrice;
    private Boolean isActive;
    private List<CatalogImageDTO> images;
    private Set<CatalogAttributeDTO> variantAttributes;
}
