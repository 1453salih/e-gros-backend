package com.korkmaz.egrosbackend.product_management.domain.repositories;


import com.korkmaz.egrosbackend.product_management.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long id);
    Category save(Category category);
    boolean existsById(Long id);
    List<Category> findAllById(Iterable<Long> ids);
}