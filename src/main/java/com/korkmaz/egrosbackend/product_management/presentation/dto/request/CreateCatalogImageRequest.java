package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogImageRequest {
    @NotBlank(message = "Image URL is required")
    private String url;

    private String altText;
    private Integer sortOrder;
    private Boolean isMain = false;
}
