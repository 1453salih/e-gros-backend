package com.korkmaz.egrosbackend.product_management.application.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String brandName;
    private String modelCode;
    private Boolean isActive;
    private Long categoryId;
    private Set<ProductAttributeDTO> attributes;
    private List<CatalogDTO> catalogs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
