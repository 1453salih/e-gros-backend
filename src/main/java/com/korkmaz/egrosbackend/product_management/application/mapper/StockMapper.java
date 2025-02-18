package com.korkmaz.egrosbackend.product_management.application.mapper;


import com.korkmaz.egrosbackend.product_management.application.dto.StockDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.Stock;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.update.UpdateStockRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.update.StockResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StockMapper {
    @Mapping(source = "catalog.id", target = "catalogId")
    StockDTO toDto(Stock entity);

    @Mapping(source = "catalogId", target = "catalog.id")
    Stock toEntity(StockDTO dto);

    @Mapping(target = "catalog", ignore = true)
    @Mapping(target = "availableQuantity", ignore = true)
    void updateStockFromDto(UpdateStockRequest dto, @MappingTarget Stock stock);

    StockResponse toResponse(Stock stock);
}
