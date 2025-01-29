package com.korkmaz.egrosbackend.product_management.application.exception;

public class InvalidAttributeTypeException extends RuntimeException {
    public InvalidAttributeTypeException(String message) {
        super(message);
    }
}