package com.korkmaz.egrosbackend.product_management.presentation.dto.response.update;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String name;
    private String slug;
    private Boolean isActive;
    private CategoryResponse parent;
    private List<CategoryResponse> subCategories;
    private Set<AttributeDefinitionResponse> attributes;
}
