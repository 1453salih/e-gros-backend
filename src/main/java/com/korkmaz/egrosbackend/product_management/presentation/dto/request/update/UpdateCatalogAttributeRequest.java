package com.korkmaz.egrosbackend.product_management.presentation.dto.request.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCatalogAttributeRequest {
    private Long attributeDefinitionId;
    private String value;
}