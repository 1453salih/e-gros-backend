package com.korkmaz.egrosbackend.product_management.application.services.product;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.mapper.ProductMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Catalog;
import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import com.korkmaz.egrosbackend.product_management.domain.exception.ProductNotFoundException;
import com.korkmaz.egrosbackend.product_management.domain.repositories.ProductRepository;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.ProductPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryProductServiceImpl implements QueryProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductPriceResponse> getProductPrice(Long productId) {
        return productRepository.findById(productId)
                .filter(Product::isActive)
                .map(product -> {
                    // Active kataloglardan (varyantlardan) en düşük satış fiyatlı olanı al şuanlık sonra düzelticem tabi
                    Optional<Catalog> activeCatalog = product.getCatalogs().stream()
                            .filter(Catalog::getIsActive)
                            .min(Comparator.comparing(Catalog::getSalesPrice));

                    return activeCatalog.map(catalog -> new ProductPriceResponse(
                            product.getId(),
                            product.getName(),
                            catalog.getSalesPrice(),
                            catalog.getListPrice(),
                            catalog.getIsActive()
                    )).orElseThrow(() -> new ProductNotFoundException("No active catalog found for product: " + productId));
                });
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        
        if (!product.isActive()) {
            throw new ProductNotFoundException("Product is not active: " + id);
        }
        
        return productMapper.toNormalDto(product);
    }
}