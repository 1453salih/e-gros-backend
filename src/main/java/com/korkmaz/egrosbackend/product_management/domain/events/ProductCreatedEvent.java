package com.korkmaz.egrosbackend.product_management.domain.events;

import java.io.Serializable;

public class ProductCreatedEvent implements Serializable {
    private final Long productId;
    private final String productName;

    public ProductCreatedEvent(Long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "ProductCreatedEvent{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
