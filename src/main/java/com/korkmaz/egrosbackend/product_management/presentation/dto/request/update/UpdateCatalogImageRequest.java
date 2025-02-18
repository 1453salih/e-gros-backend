package com.korkmaz.egrosbackend.product_management.presentation.dto.request.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCatalogImageRequest {
    private String url;
    private String altText;
    private Integer sortOrder;
    private Boolean isMain;
}