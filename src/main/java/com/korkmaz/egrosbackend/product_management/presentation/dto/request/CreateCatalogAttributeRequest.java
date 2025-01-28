package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogAttributeRequest {
    private Long attributeDefinitionId;
    private String value;
}
