package com.korkmaz.egrosbackend.product_management.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateProductResponse {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String brandName;
    private String modelCode;
    private Boolean isActive;
    private CreateCategoryResponse category;
    private Set<CreateProductAttributeResponse> attributes;
    private List<CreateCatalogResponse> catalogs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
