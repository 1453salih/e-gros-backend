package com.korkmaz.egrosbackend.product_management.domain.exception;

public class CategoryNotFoundException extends ProductDomainException {
    public CategoryNotFoundException(Long id) {
        super(String.format("Category not found with id: %d", id));
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
