package com.korkmaz.egrosbackend.product_management.presentation.dto.request.update;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateCategoryRequest {
    private String name;
    private String slug;
    private Boolean isActive;
    private Long parentId;
}