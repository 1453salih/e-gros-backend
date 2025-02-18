package com.korkmaz.egrosbackend.product_management.presentation.dto.response.update;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String brandName;
    private String modelCode;
    private boolean isActive;
    private CategoryResponse category;
    private Set<ProductAttributeResponse> attributes;
    private List<CatalogResponse> catalogs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}