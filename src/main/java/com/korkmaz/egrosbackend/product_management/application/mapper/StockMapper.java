package com.korkmaz.egrosbackend.product_management.application.mapper;


import com.korkmaz.egrosbackend.product_management.application.dto.StockDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMapper {
    @Mapping(source = "catalog.id", target = "catalogId")
    StockDTO toDto(Stock entity);

    @Mapping(source = "catalogId", target = "catalog.id")
    Stock toEntity(StockDTO dto);
}
