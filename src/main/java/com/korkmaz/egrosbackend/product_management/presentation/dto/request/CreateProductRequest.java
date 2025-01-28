package com.korkmaz.egrosbackend.product_management.presentation.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest { //
    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @NotBlank(message = "Brand name is required")
    private String brandName;

    @NotBlank(message = "Model code is required")
    private String modelCode;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    private Set<CreateProductAttributeRequest> attributes;

    @NotNull(message = "Catolog is required")
    private List<CreateCatalogRequest> catalogs;
}
