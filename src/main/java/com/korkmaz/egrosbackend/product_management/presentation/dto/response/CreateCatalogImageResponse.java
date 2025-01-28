package com.korkmaz.egrosbackend.product_management.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCatalogImageResponse {
    private Long id;
    private String url;
    private String altText;
    private Integer sortOrder;
    private Boolean isMain;
}
