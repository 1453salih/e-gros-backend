package com.korkmaz.egrosbackend.product_management.application.services.product;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.mapper.ProductMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Product;
import com.korkmaz.egrosbackend.product_management.domain.events.ProductCreatedEvent;
import com.korkmaz.egrosbackend.product_management.domain.repositories.ProductRepository;
import com.korkmaz.egrosbackend.product_management.infrastructure.events.rabbitmq.RabbitMQEventPublisher;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CreateProductServiceImpl implements CreateProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final RabbitMQEventPublisher eventPublisher;

    public CreateProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, RabbitMQEventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    @Override
    public ProductDTO createProduct(CreateProductRequest request) {
        Product product = productMapper.toEntity(request);

        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        // RabbitMQ'ya olay gönder
        ProductCreatedEvent event = new ProductCreatedEvent(savedProduct.getId(), savedProduct.getName());
        eventPublisher.publishProductCreatedEvent(event);

        return productMapper.toDto(savedProduct);
    }
}
