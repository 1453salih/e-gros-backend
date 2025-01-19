package com.korkmaz.egrosbackend.product_management.application.services.product;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.mapper.ProductMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import com.korkmaz.egrosbackend.product_management.domain.repositories.ProductRepository;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CreateProductServiceImpl implements CreateProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public CreateProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    @Override
    public ProductDTO createProduct(CreateProductRequest request) {
        Product product = productMapper.toEntity(request);

        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);


        return productMapper.toDto(savedProduct);
    }
}
