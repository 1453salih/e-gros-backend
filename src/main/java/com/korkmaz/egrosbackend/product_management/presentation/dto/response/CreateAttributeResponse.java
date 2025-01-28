package com.korkmaz.egrosbackend.product_management.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateAttributeResponse {
    private Long id;
    private String name;
    private String type;
    private Boolean isRequired;
    private Boolean isVariant;
    private Integer sortOrder;
    private Set<Long> categoryIds; // İlişkili kategori ID'leri
}
