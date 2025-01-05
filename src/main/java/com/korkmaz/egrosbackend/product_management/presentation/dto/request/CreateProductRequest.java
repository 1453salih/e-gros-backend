package com.korkmaz.egrosbackend.product_management.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    private String name;
    private String slug;
    private String description;
    private String brandName;
    private String modelCode;
    private Boolean isActive;
    private Long categoryId;
    private Set<CreateProductAttributeRequest> attributes;
    private List<CreateCatalogRequest> catalogs;
}
