package com.korkmaz.egrosbackend.product_management.presentation.controller;

import com.korkmaz.egrosbackend.product_management.application.dto.CategoryDTO;
import com.korkmaz.egrosbackend.product_management.application.services.AddCategoryServiceImpl;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCategoryRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final AddCategoryServiceImpl categoryService;

    public CategoryController(AddCategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CreateCategoryRequest request) {
        CategoryDTO createdCategory = categoryService.addCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }
}
