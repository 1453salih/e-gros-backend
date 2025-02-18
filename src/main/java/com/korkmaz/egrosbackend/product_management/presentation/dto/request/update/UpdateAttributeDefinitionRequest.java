package com.korkmaz.egrosbackend.product_management.presentation.dto.request.update;

import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UpdateAttributeDefinitionRequest {
    private String name;
    private String type;
    private Boolean isRequired;
    private Boolean isVariant;
    private Integer sortOrder;
    private Set<Long> categoryIds;
}