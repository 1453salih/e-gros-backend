package com.korkmaz.egrosbackend.product_management.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCategoryRequest {
    private String name;
    private String slug;
    private Boolean isActive = true;
    private Long parentId;
}