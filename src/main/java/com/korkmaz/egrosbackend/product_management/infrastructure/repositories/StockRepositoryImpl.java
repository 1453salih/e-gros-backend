package com.korkmaz.egrosbackend.product_management.infrastructure.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.Stock;
import com.korkmaz.egrosbackend.product_management.domain.repositories.StockRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StockRepositoryImpl extends JpaRepository<Stock, Long>, StockRepository {
    Optional<Stock> findByCatalogId(Long catalogId);

    @Query("SELECT s FROM Stock s WHERE s.catalog.id = :catalogId AND s.availableQuantity >= :quantity")
    Optional<Stock> findAvailableStock(Long catalogId, Integer quantity);
}
