package com.korkmaz.egrosbackend.product_management.domain.repository;

import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
