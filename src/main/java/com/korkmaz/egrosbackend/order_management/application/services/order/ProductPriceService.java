package com.korkmaz.egrosbackend.order_management.application.services.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class ProductPriceService {
    private final WebClient productWebClient;

    public Double getProductPrice(Long productId) {
        return productWebClient.get()
                .uri("/api/v1/products/{id}/price", productId)
                .retrieve()
                .bodyToMono(Double.class)
                .block(); // Reactive programlama için bu kısmı Mono olarak da kalabilir
    }
}