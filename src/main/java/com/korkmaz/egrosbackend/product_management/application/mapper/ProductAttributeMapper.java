package com.korkmaz.egrosbackend.product_management.application.mapper;


import com.korkmaz.egrosbackend.product_management.domain.entity.ProductAttribute;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateProductAttributeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductAttributeMapper {

    @Mapping(target = "attributeDefinition.id", source = "attributeDefinitionId")
    ProductAttribute toEntity(CreateProductAttributeRequest request);

    @Mapping(target = "attributeDefinition", source = "attributeDefinition")
    CreateProductAttributeResponse toDto(ProductAttribute attribute);
}
