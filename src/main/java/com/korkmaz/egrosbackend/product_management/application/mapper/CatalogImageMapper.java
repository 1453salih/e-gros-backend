package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.CatalogImageDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.CatalogImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatalogImageMapper {
    CatalogImage toEntity(CatalogImageDTO dto);
    CatalogImageDTO toDto(CatalogImage entity);
}
