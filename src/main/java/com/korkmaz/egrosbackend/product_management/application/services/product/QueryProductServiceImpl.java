package com.korkmaz.egrosbackend.product_management.application.services.product;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.mapper.ProductMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Catalog;
import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import com.korkmaz.egrosbackend.product_management.domain.repositories.ProductRepository;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.ProductPriceResponse;
import jakarta.persistence.EntityNotFoundException;
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
                .filter(Product::getIsActive)
                .map(product -> {
                    // Active kataloglardan en düşük satış fiyatlı olanı al şuanlık sonra düzelticem tabi
                    Optional<Catalog> activeCatalog = product.getCatalogs().stream()
                            .filter(Catalog::getIsActive)
                            .min(Comparator.comparing(Catalog::getSalesPrice));

                    if (activeCatalog.isPresent()) {
                        Catalog catalog = activeCatalog.get();
                        return new ProductPriceResponse(
                                product.getId(),
                                product.getName(),
                                catalog.getSalesPrice(),
                                catalog.getListPrice(),
                                catalog.getIsActive()
                        );
                    }
                    return null;
                });
    }
    @Override
    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }
}