package com.korkmaz.egrosbackend.product_management.application.exception;

public class AttributeAlreadyExistsException extends RuntimeException {
    public AttributeAlreadyExistsException(String message) {
        super(message);
    }
}