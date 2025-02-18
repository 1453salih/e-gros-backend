package com.korkmaz.egrosbackend.product_management.presentation.dto.response.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogImageResponse {
    private Long id;
    private String url;
    private String altText;
    private Integer sortOrder;
    private Boolean isMain;
}