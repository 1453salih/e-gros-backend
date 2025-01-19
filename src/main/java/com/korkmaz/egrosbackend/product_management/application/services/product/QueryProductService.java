package com.korkmaz.egrosbackend.product_management.application.services.product;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.ProductPriceResponse;

import java.util.Optional;

public interface QueryProductService {
    Optional<ProductPriceResponse> getProductPrice(Long productId);
    ProductDTO getProductById(Long id);
}
