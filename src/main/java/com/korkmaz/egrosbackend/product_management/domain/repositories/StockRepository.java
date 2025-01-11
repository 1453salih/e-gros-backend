package com.korkmaz.egrosbackend.product_management.domain.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.Stock;
import java.util.Optional;

public interface StockRepository{
    Optional<Stock> findByCatalogId(Long catalogId);
    Optional<Stock> findAvailableStock(Long catalogId, Integer quantity);
}
