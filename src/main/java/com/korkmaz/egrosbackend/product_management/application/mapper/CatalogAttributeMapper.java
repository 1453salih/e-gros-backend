package com.korkmaz.egrosbackend.product_management.application.mapper;


import com.korkmaz.egrosbackend.product_management.domain.entity.CatalogAttribute;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCatalogAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.update.UpdateCatalogAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCatalogAttributeResponse;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.update.CatalogAttributeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CatalogAttributeMapper {

    @Mapping(target = "attributeDefinition.id", source = "attributeDefinitionId")
    CatalogAttribute toEntity(CreateCatalogAttributeRequest request);

    @Mapping(target = "attributeDefinition", source = "attributeDefinition")
    CreateCatalogAttributeResponse toDto(CatalogAttribute attribute);


    @Mapping(target = "catalog", ignore = true)
    @Mapping(target = "attributeDefinition", ignore = true)
    void updateCatalogAttributeFromDto(UpdateCatalogAttributeRequest dto, @MappingTarget CatalogAttribute catalogAttribute);

    CatalogAttributeResponse toResponse(CatalogAttribute catalogAttribute);
}
