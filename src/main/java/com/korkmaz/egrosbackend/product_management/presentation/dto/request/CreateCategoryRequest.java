package com.korkmaz.egrosbackend.product_management.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCategoryRequest {
    private String name;
    private String slug;
    private Boolean isActive;
    private Long parentId;
}