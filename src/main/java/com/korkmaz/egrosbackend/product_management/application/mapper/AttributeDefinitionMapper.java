package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;

import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateAttributeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AttributeDefinitionMapper {

    @Mapping(target = "categories", ignore = true) // Kategorileri manuel eşleştireceğiz
    AttributeDefinition toEntity(CreateAttributeRequest request);


    CreateAttributeResponse toResponse(AttributeDefinition attributeDefinition);


    //ID'yi category nesnesine çevirir
    default Set<Category> mapCategoryIds(Set<Long> categoryIds) {
        if (categoryIds == null) {
            return null;
        }
        return categoryIds.stream()
                .map(id -> {
                    Category category = new Category();
                    category.setId(id);
                    return category;
                })
                .collect(Collectors.toSet());
    }
}
