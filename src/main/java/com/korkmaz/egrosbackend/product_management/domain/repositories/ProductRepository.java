package com.korkmaz.egrosbackend.product_management.domain.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ProductRepository{
    Product save(Product product);
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.catalogs WHERE p.id = :id")
    Optional<Product> findById(@Param("id") Long id);
}
