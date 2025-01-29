package com.korkmaz.egrosbackend.product_management.domain.exception;

public class ProductNotFoundException extends ProductDomainException {
    public ProductNotFoundException(Long id) {
        super(String.format("Product not found with id: %d", id));
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
