package com.korkmaz.egrosbackend.product_management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttributeDefinitionDTO {
    private Long id;
    private String name;
    private String type;
    private Boolean isRequired;
    private Boolean isVariant;
    private Integer sortOrder;
    private Set<Long> categoryIds;
}