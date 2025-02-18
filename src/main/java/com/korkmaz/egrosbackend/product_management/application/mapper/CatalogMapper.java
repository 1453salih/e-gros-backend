package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.domain.entity.Catalog;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCatalogRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.update.UpdateCatalogRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCatalogResponse;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.update.CatalogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {CatalogAttributeMapper.class, CatalogImageMapper.class, StockMapper.class}
)
public interface CatalogMapper {

    @Mapping(target = "variantAttributes", source = "variantAttributes")
    @Mapping(target = "images", source = "images")
    Catalog toEntity(CreateCatalogRequest request);

    @Mapping(target = "variantAttributes", source = "variantAttributes")
    @Mapping(target = "images", source = "images")
    CreateCatalogResponse toDto(Catalog catalog);


    @Mapping(target = "product", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "variantAttributes", ignore = true)
    @Mapping(target = "stock", ignore = true)
    void updateCatalogFromDto(UpdateCatalogRequest dto, @MappingTarget Catalog catalog);

    CatalogResponse toResponse(Catalog catalog);
}
