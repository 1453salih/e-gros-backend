package com.korkmaz.egrosbackend.product_management.infrastructure.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.domain.repositories.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryImpl extends JpaRepository<Category, Long>, CategoryRepository {

}
