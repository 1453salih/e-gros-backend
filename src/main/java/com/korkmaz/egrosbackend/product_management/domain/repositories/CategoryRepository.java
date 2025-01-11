package com.korkmaz.egrosbackend.product_management.domain.repositories;


import com.korkmaz.egrosbackend.product_management.domain.entity.Category;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long id);
    Category save(Category category);
}