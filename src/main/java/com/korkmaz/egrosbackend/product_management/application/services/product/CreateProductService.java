package com.korkmaz.egrosbackend.product_management.application.services.product;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import org.springframework.stereotype.Service;




//TODO: ProductDTO yerine CreateProductRepsonse ile yanıt dönecek.

@Service
public interface CreateProductService {
    ProductDTO createProduct(CreateProductRequest request);
}
