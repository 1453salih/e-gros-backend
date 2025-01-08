package com.korkmaz.egrosbackend.product_management.presentation.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCategoryResponse {
    private Long id;
    private String name;
    private String slug;
    private Boolean isActive;
    private Long parentId;
}
