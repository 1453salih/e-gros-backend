package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.*;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.*;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.update.UpdateProductRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.*;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.update.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {CategoryMapper.class, ProductAttributeMapper.class, CatalogMapper.class})
public interface ProductMapper {

    @Mapping(target = "category", ignore = true) // Category ID referans olduğundan doğrudan bağlanacak.
    @Mapping(target = "catalogs", source = "catalogs")
    @Mapping(target = "attributes", source = "attributes")
    Product toEntity(CreateProductRequest request);

    @Mapping(target = "category", source = "category")
    @Mapping(target = "catalogs", source = "catalogs")
    @Mapping(target = "attributes", source = "attributes")
    CreateProductResponse toDto(Product product);

    ProductDTO toNormalDto(Product product); // Get Metodu Applicaitondaki Dto'yu kullandığı için yazıldı.
    Product toNormalEntity(ProductDTO productDTO);


    @Mapping(target = "category", ignore = true)
    @Mapping(target = "attributes", ignore = true)
    @Mapping(target = "catalogs", ignore = true)
    void updateProductFromDto(UpdateProductRequest dto, @MappingTarget Product product);

    ProductResponse toResponse(Product product);

}
