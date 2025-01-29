package com.korkmaz.egrosbackend.product_management.infrastructure.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import com.korkmaz.egrosbackend.product_management.domain.repositories.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Long>, ProductRepository {
}
