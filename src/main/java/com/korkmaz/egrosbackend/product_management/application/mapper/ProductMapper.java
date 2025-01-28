package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.*;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.*;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring", uses = {CatalogMapper.class, ProductAttributeMapper.class})
public interface ProductMapper {

    @Mapping(target = "category", ignore = true) // Category ID referans olduğundan doğrudan bağlanacak.
    @Mapping(target = "catalogs", source = "catalogs")
    @Mapping(target = "attributes", source = "attributes")
    Product toEntity(CreateProductRequest request);

    @Mapping(target = "category", source = "category")
    @Mapping(target = "catalogs", source = "catalogs")
    @Mapping(target = "attributes", source = "attributes")
    CreateProductResponse toDto(Product product);


    ProductDTO toNormalDto(Product product); //Get Metodu Applicaitondaki Dto'yu kullandığı için yazıldı.
    Product toNormalEntity(ProductDTO productDTO);
}
