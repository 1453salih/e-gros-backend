package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogAttributeRequest {
    private Long attributeDefinitionId;
    private String value;
}
