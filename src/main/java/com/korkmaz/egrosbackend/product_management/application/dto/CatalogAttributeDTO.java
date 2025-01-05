package com.korkmaz.egrosbackend.product_management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogAttributeDTO {
    private Long id;
    private Long catalogId;
    private Long attributeDefinitionId;
    private String value;
}
