package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, ProductAttributeMapper.class, CatalogMapper.class})
public interface ProductMapper {
    Product toEntity(CreateProductRequest request);

    ProductDTO toDto(Product product);
}
