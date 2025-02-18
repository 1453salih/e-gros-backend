package com.korkmaz.egrosbackend.product_management.application.mapper;


import com.korkmaz.egrosbackend.product_management.domain.entity.CatalogImage;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCatalogImageRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.update.UpdateCatalogImageRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCatalogImageResponse;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.update.CatalogImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CatalogImageMapper {

    CatalogImage toEntity(CreateCatalogImageRequest request);

    CreateCatalogImageResponse toDto(CatalogImage image);
    @Mapping(target = "catalog", ignore = true)
    void updateCatalogImageFromDto(UpdateCatalogImageRequest dto, @MappingTarget CatalogImage catalogImage);

    CatalogImageResponse toResponse(CatalogImage catalogImage);
}
