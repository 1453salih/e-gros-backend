package com.korkmaz.egrosbackend.product_management.presentation.controller;

import com.korkmaz.egrosbackend.product_management.application.services.category.CreateCategoryServiceImpl;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCategoryRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCategoryResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CreateCategoryServiceImpl categoryService;

    public CategoryController(CreateCategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/add")
    public ResponseEntity<CreateCategoryResponse> createCategory(@Valid @RequestBody CreateCategoryRequest request) {
        CreateCategoryResponse createdCategory = categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }
}
