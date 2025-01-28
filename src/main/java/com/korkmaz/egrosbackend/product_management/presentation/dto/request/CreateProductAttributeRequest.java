package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductAttributeRequest {
    @NotNull(message = "Attribute definition ID is required")
    private Long attributeDefinitionId;

    @NotBlank(message = "Attribute value is required")
    private String value;
}
