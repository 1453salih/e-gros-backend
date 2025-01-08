package com.korkmaz.egrosbackend.product_management.infrastructure.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
