package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;
import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeType;
import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.update.UpdateAttributeDefinitionRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateAttributeResponse;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.update.AttributeDefinitionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, Category.class})
public interface AttributeDefinitionMapper {

    @Mapping(target = "categories", ignore = true)
    AttributeDefinition toEntity(CreateAttributeRequest request);

    @Mapping(target = "categoryIds", expression = "java(attributeDefinition.getCategories().stream().map(Category::getId).collect(Collectors.toSet()))")
    CreateAttributeResponse toResponse(AttributeDefinition attributeDefinition);

    @Mapping(target = "categories", ignore = true)
    void updateAttributeDefinitionFromDto(UpdateAttributeDefinitionRequest dto, @MappingTarget AttributeDefinition attributeDefinition);

    AttributeDefinitionResponse toResponsed(AttributeDefinition attributeDefinition);
}