package com.korkmaz.egrosbackend.product_management.domain.repository;

import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
