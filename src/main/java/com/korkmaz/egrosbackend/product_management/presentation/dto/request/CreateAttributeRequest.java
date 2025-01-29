package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateAttributeRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Type is required")
    private AttributeType type;

    @NotNull(message = "isRequired field is required")
    private Boolean isRequired;

    @NotNull(message = "isVariant field is required")
    private Boolean isVariant;

    @Min(value = 0, message = "Sort order cannot be negative")
    private Integer sortOrder;

    @NotEmpty(message = "At least one category must be selected")
    private Set<Long> categoryIds;
}