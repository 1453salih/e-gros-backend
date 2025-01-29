package com.korkmaz.egrosbackend.product_management.application.services.product;

import com.korkmaz.egrosbackend.product_management.application.mapper.ProductMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import com.korkmaz.egrosbackend.product_management.domain.exception.CategoryNotFoundException;
import com.korkmaz.egrosbackend.product_management.domain.exception.InvalidProductStateException;
import com.korkmaz.egrosbackend.product_management.domain.repositories.CategoryRepository;
import com.korkmaz.egrosbackend.product_management.domain.repositories.ProductRepository;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateProductResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductServiceImpl implements CreateProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public CreateProductResponse createProduct(CreateProductRequest request) {
        // 1. Category'yi ID üzerinden bulur
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(request.getCategoryId()));

        // 2. CreateProductRequest'i Product entity'sine dönüştürür
        Product product = productMapper.toEntity(request);

        // Validasyon kontrolleri
        validateProduct(product);

        // 3. Category Product ile ilişkilendirilir
        product.setCategory(category);

        // 4. Attribute persist edilirken product bilgisi verilmeli
        product.getAttributes().forEach(attribute -> attribute.setProduct(product));

        // 5. Kataloglar persist edilirken product bilgisi verilmeli
        product.getCatalogs().forEach(catalog -> {
            catalog.setProduct(product);
            if (catalog.getSalesPrice().compareTo(catalog.getListPrice()) > 0) {
                throw new InvalidProductStateException("Sales price cannot be greater than list price for catalog SKU: " + catalog.getSku());
            }
        });

        // 6. Product ve ilişkili Catalog'ları kaydeder
        Product savedProduct = productRepository.save(product);

        // 7. Saved Product'ı CreateProductResponse'a dönüştürür
        return productMapper.toDto(savedProduct);
    }

    private void validateProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new InvalidProductStateException("Product name cannot be empty");
        }
        if (product.getCatalogs().isEmpty()) {
            throw new InvalidProductStateException("Product must have at least one catalog");
        }
        if (product.getAttributes().isEmpty()) {
            throw new InvalidProductStateException("Product must have at least one attribute");
        }
    }
}