package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogAttributeRequest {

    @NotNull(message = "Attribute definition ID is required")
    private Long attributeDefinitionId;

    @NotNull(message = "Value cannot be null")
    @Size(min = 1, max = 50, message = "Value must be between 1 and 50 characters")
    private String value;
}
