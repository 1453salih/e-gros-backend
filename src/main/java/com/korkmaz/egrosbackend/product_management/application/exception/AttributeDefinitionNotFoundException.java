package com.korkmaz.egrosbackend.product_management.application.exception;

public class AttributeDefinitionNotFoundException extends RuntimeException {
    public AttributeDefinitionNotFoundException(String message) {
        super(message);
    }
}