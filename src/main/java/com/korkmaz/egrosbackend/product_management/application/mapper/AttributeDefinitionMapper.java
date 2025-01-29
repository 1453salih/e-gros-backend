package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;
import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeType;
import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateAttributeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, Category.class})
public interface AttributeDefinitionMapper {

    @Mapping(target = "categories", ignore = true)
    AttributeDefinition toEntity(CreateAttributeRequest request);

    @Mapping(target = "categoryIds", expression = "java(attributeDefinition.getCategories().stream().map(Category::getId).collect(Collectors.toSet()))")
    CreateAttributeResponse toResponse(AttributeDefinition attributeDefinition);
}