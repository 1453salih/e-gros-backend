package com.korkmaz.egrosbackend.product_management.presentation.controller;

import com.korkmaz.egrosbackend.product_management.application.dto.ProductDTO;
import com.korkmaz.egrosbackend.product_management.application.services.product.CreateProductService;
import com.korkmaz.egrosbackend.product_management.application.services.product.QueryProductService;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.ProductPriceResponse;
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

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductRequest request) {
        ProductDTO createdProduct = createProductService.createProduct(request);
        return ResponseEntity.ok(createdProduct);
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
}
