package com.korkmaz.egrosbackend.product_management.presentation.dto.response.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAttributeResponse {
    private Long id;
    private AttributeDefinitionResponse attributeDefinition;
    private String value;
}