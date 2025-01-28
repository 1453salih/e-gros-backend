package com.korkmaz.egrosbackend.product_management.application.services.category;

import com.korkmaz.egrosbackend.product_management.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryValidationService {
    private final CategoryRepository categoryRepository;

    public void validateCategoryIds(Set<Long> categoryIds) {
        if (categoryIds == null || categoryIds.isEmpty()) {
            return;
        }

        Set<Long> nonExistentCategories = categoryIds.stream()
            .filter(id -> !categoryRepository.existsById(id))
            .collect(Collectors.toSet());

        if (!nonExistentCategories.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz kategori ID'si: " + nonExistentCategories);
        }
    }
}