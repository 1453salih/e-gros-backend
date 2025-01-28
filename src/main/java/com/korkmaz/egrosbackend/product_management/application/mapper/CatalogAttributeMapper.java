package com.korkmaz.egrosbackend.product_management.application.mapper;


import com.korkmaz.egrosbackend.product_management.domain.entity.CatalogAttribute;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCatalogAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCatalogAttributeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CatalogAttributeMapper {

    @Mapping(target = "attributeDefinition.id", source = "attributeDefinitionId")
    CatalogAttribute toEntity(CreateCatalogAttributeRequest request);

    @Mapping(target = "attributeDefinition", source = "attributeDefinition")
    CreateCatalogAttributeResponse toDto(CatalogAttribute attribute);
}
