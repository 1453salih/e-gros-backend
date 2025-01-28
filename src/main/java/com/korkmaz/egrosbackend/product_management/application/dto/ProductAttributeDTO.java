package com.korkmaz.egrosbackend.product_management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeDTO {
    private Long id;
    private Long productId;
    private Long attributeDefinitionId;
    private String value;
}
