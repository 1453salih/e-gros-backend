package com.korkmaz.egrosbackend.product_management.application.services;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.mapper.ProductMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import com.korkmaz.egrosbackend.product_management.infrastructure.repositories.ProductRepository;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    @Override
    public ProductDTO addProduct(CreateProductRequest request) {
        Product product = productMapper.toEntity(request);

        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }
}
