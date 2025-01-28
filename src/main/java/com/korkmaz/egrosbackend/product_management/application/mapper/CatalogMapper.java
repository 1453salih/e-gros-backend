package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.domain.entity.Catalog;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCatalogRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCatalogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CatalogAttributeMapper.class, CatalogImageMapper.class})
public interface CatalogMapper {

    @Mapping(target = "variantAttributes", source = "variantAttributes")
    @Mapping(target = "images", source = "images")
    Catalog toEntity(CreateCatalogRequest request);

    @Mapping(target = "variantAttributes", source = "variantAttributes")
    @Mapping(target = "images", source = "images")
    CreateCatalogResponse toDto(Catalog catalog);
}
