package com.korkmaz.egrosbackend.product_management.presentation.controller;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.services.ProductService;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody CreateProductRequest request) {
        ProductDTO createdProduct = productService.addProduct(request);
        return ResponseEntity.ok(createdProduct);
    }
}
