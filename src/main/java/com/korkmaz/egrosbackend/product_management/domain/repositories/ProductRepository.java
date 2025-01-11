package com.korkmaz.egrosbackend.product_management.domain.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.Product;


public interface ProductRepository{
    Product save(Product product);
}
