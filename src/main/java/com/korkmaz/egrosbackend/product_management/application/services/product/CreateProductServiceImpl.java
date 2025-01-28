package com.korkmaz.egrosbackend.product_management.application.services.product;


import com.korkmaz.egrosbackend.product_management.application.mapper.ProductMapper;

import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
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
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // 2. CreateProductRequest'i Product entity'sine dönüştürür
        Product product = productMapper.toEntity(request);

        // 3. Category Product ile ilişkilendirilir
        product.setCategory(category);

        // 4. Attribute persist edilirken product bilgisi verilmeli yoksa null kaydediyor ilişkiyi yöneten taraf olmadığından dolayı
        product.getAttributes().forEach(attribute -> attribute.setProduct(product));

        // 5. Kataloglar persist edilirken product bilgisi verilmeli yoksa null kaydediyor ilişkiyi yöneten taraf olmadığından dolayı
        product.getCatalogs().forEach(catalog -> catalog.setProduct(product));

        // 6. Product ve ilişkili Catalog'ları kaydeder
        Product savedProduct = productRepository.save(product);

        // 7. Saved Product'ı CreateProductResponse'a dönüştürür
        return productMapper.toDto(savedProduct);
    }
}