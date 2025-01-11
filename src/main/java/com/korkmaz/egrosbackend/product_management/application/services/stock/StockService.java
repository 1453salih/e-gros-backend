package com.korkmaz.egrosbackend.product_management.application.services.stock;

import com.korkmaz.egrosbackend.product_management.application.dto.StockDTO;
import com.korkmaz.egrosbackend.product_management.application.mapper.StockMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Stock;
import com.korkmaz.egrosbackend.product_management.infrastructure.repositories.StockRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepositoryImpl stockRepositoryImpl;
    private final StockMapper stockMapper;
    
    @Transactional(readOnly = true)
    public StockDTO getStockByCatalogId(Long catalogId) {
        Stock stock = stockRepositoryImpl.findByCatalogId(catalogId)
            .orElseThrow(() -> new RuntimeException("Stock not found for catalog: " + catalogId));
        return stockMapper.toDto(stock);
    }
    
    @Transactional
    public StockDTO updateStock(StockDTO stockDTO) {
        Stock stock = stockRepositoryImpl.findByCatalogId(stockDTO.getCatalogId())
            .orElseThrow(() -> new RuntimeException("Stock not found for catalog: " + stockDTO.getCatalogId()));
        
        stock.setQuantity(stockDTO.getQuantity());
        stock.setReservedQuantity(stockDTO.getReservedQuantity());
        stock.setLastUpdated(LocalDateTime.now());
        stock.setUpdatedBy(stockDTO.getUpdatedBy());
        
        stock = stockRepositoryImpl.save(stock);
        return stockMapper.toDto(stock);
    }
    
    @Transactional
    public boolean reserveStock(Long catalogId, Integer quantity) {
        return stockRepositoryImpl.findAvailableStock(catalogId, quantity)
            .map(stock -> {
                stock.setReservedQuantity(stock.getReservedQuantity() + quantity);
                stockRepositoryImpl.save(stock);
                return true;
            })
            .orElse(false);
    }
}