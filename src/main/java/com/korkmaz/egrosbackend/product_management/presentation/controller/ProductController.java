package com.korkmaz.egrosbackend.product_management.presentation.controller;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.services.product.CreateProductService;
import com.korkmaz.egrosbackend.product_management.application.services.product.QueryProductService;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateProductResponse;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.ProductPriceResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final CreateProductService createProductService;
    private final QueryProductService queryProductService;

    public ProductController(CreateProductService createProductService, QueryProductService queryProductService) {
        this.createProductService = createProductService;
        this.queryProductService = queryProductService;
    }

    @GetMapping("/{id}/price")
    public ResponseEntity<ProductPriceResponse> getProductPrice(@PathVariable Long id) {
        return queryProductService.getProductPrice(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(queryProductService.getProductById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        CreateProductResponse response = createProductService.createProduct(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
