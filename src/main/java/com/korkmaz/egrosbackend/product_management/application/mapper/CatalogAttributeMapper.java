package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.CatalogAttributeDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.CatalogAttribute;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AttributeDefinitionMapper.class})
public interface CatalogAttributeMapper {
    CatalogAttribute toEntity(CatalogAttributeDTO dto);
    CatalogAttributeDTO toDto(CatalogAttribute entity);
}

