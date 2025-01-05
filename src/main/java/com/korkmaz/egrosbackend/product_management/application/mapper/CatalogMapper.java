package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.CatalogDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.Catalog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CatalogImageMapper.class, CatalogAttributeMapper.class})
public interface CatalogMapper {
    Catalog toEntity(CatalogDTO dto);
    CatalogDTO toDto(Catalog entity);
}

