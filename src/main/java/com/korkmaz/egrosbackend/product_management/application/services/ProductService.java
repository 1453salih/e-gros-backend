package com.korkmaz.egrosbackend.product_management.application.services;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductDTO addProduct(CreateProductRequest request);
}
