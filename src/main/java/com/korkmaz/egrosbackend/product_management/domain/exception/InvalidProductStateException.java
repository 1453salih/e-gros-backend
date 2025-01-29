package com.korkmaz.egrosbackend.product_management.domain.exception;

public class InvalidProductStateException extends ProductDomainException {
    public InvalidProductStateException(String message) {
        super(message);
    }
}
