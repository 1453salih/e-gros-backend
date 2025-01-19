package com.korkmaz.egrosbackend.order_management.application.services.order;

import com.korkmaz.egrosbackend.order_management.domain.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderPriceCalculationServiceImpl implements OrderPriceCalculationService {
    private final WebClient webClient;

    @Override
    public Mono<Double> getProductPrice(Long productId) {
        return webClient.get()
                .uri("/api/products/{productId}/price", productId)
                .retrieve()
                .bodyToMono(Double.class);
    }

    @Override
    public void calculateItemPrices(OrderItem item) {
        Double unitPrice = getProductPrice(item.getProductId()).block();
        item.setUnitPrice(unitPrice);
        item.setTotalPrice(unitPrice * item.getQuantity());
    }
}