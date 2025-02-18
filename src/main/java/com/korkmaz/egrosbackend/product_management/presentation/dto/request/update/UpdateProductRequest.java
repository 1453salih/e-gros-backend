package com.korkmaz.egrosbackend.product_management.presentation.dto.request.update;

import lombok.*;


@Getter
@Setter
public class UpdateProductRequest {
    private String name;
    private String description;
    private String brandName;
    private String modelCode;
    private Boolean isActive;
    private Long categoryId;
}


