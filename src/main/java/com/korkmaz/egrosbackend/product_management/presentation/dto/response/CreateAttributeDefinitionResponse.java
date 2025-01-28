package com.korkmaz.egrosbackend.product_management.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateAttributeDefinitionResponse {
    private Long id;
    private String name;
    private String type;
    private Boolean isRequired;
    private Boolean isVariant;
    private Integer sortOrder;
}
