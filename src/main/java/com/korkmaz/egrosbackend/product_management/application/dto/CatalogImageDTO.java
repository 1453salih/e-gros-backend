package com.korkmaz.egrosbackend.product_management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogImageDTO {
    private Long id;
    private Long catalogId;
    private String url;
    private String altText;
    private Integer sortOrder;
    private Boolean isMain;
}
