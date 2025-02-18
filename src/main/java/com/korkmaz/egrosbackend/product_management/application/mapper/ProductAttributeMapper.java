package com.korkmaz.egrosbackend.product_management.application.mapper;



import com.korkmaz.egrosbackend.product_management.domain.entity.ProductAttribute;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.update.UpdateProductAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateProductAttributeResponse;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.update.ProductAttributeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductAttributeMapper {

    @Mapping(target = "attributeDefinition.id", source = "attributeDefinitionId")
    ProductAttribute toEntity(CreateProductAttributeRequest request);

    @Mapping(target = "attributeDefinition", source = "attributeDefinition")
    CreateProductAttributeResponse toDto(ProductAttribute attribute);


    @Mapping(target = "product", ignore = true)
    @Mapping(target = "attributeDefinition", ignore = true)
    void updateProductAttributeFromDto(UpdateProductAttributeRequest dto, @MappingTarget ProductAttribute productAttribute);

    ProductAttributeResponse toResponse(ProductAttribute productAttribute);
}
