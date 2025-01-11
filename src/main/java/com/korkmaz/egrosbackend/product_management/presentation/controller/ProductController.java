package com.korkmaz.egrosbackend.product_management.presentation.controller;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.services.product.CreateProductService;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final CreateProductService createProductService;

    public ProductController(CreateProductService createProductService) {
        this.createProductService = createProductService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductRequest request) {
        ProductDTO createdProduct = createProductService.createProduct(request);
        return ResponseEntity.ok(createdProduct);
    }
}
