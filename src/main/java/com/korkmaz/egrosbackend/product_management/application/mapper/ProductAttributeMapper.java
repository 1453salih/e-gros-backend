package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductAttributeDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.ProductAttribute;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AttributeDefinitionMapper.class})
public interface ProductAttributeMapper {
    ProductAttribute toEntity(ProductAttributeDTO dto);
    ProductAttributeDTO toDto(ProductAttribute entity);
}
