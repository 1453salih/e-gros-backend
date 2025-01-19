package com.korkmaz.egrosbackend.order_management.domain.exception;

public class ProductPriceNotFoundException extends RuntimeException {
    public ProductPriceNotFoundException(String message) {
        super(message);
    }
}