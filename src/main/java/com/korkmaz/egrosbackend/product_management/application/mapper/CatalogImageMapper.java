package com.korkmaz.egrosbackend.product_management.application.mapper;


import com.korkmaz.egrosbackend.product_management.domain.entity.CatalogImage;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCatalogImageRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCatalogImageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatalogImageMapper {

    CatalogImage toEntity(CreateCatalogImageRequest request);

    CreateCatalogImageResponse toDto(CatalogImage image);
}
