package com.korkmaz.egrosbackend.product_management.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCatalogAttributeResponse {
    private Long id;
    private CreateAttributeDefinitionResponse attributeDefinition;
    private String value;
}
