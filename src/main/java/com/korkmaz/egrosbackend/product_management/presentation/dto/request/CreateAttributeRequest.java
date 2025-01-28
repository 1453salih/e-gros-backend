package com.korkmaz.egrosbackend.product_management.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateAttributeRequest {
    private String name;        // Renk, Beden, Malzeme, RAM, Ekran Boyutu vs.
    private String type;        // TEXT, NUMBER, BOOLEAN vs.
    private Boolean isRequired;
    private Boolean isVariant;
    private Integer sortOrder;
    private Set<Long> categoryIds; // İlişkili kategori ID'leri
}