package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Pattern(regexp = "^(https?|ftp)://.*$", message = "Invalid URL format")
    private String url;

    @Size(max = 255, message = "Alt text cannot exceed 255 characters")
    private String altText;

    private Integer sortOrder;

    private Boolean isMain = false;
}
