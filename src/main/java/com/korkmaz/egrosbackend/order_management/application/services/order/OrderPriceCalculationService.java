package com.korkmaz.egrosbackend.order_management.application.services.order;

import com.korkmaz.egrosbackend.order_management.domain.entity.OrderItem;
import reactor.core.publisher.Mono;

public interface OrderPriceCalculationService {
    Mono<Double> getProductPrice(Long productId);
    void calculateItemPrices(OrderItem item);
}