package com.korkmaz.egrosbackend.product_management.application.services;

import com.korkmaz.egrosbackend.product_management.application.dto.CategoryDTO;
import com.korkmaz.egrosbackend.product_management.application.mapper.CategoryMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.domain.repository.CategoryRepository;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCategoryRequest;

public class AddCategoryServiceImpl implements AddCategoryService{



    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public AddCategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO addCategory(CreateCategoryRequest request) {
        // DTO'dan Entity'e dönüşüm
        Category category = categoryMapper.toEntity(request);

        // Parent kategori kontrolü
        if (request.getParentId() != null) {
            Category parentCategory = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent category not found with id: " + request.getParentId()));
            category.setParent(parentCategory);
        }

        // Kategoriyi kaydet
        Category savedCategory = categoryRepository.save(category);

        // Entity'den DTO'ya dönüşüm
        return categoryMapper.toDto(savedCategory);
    }

}
