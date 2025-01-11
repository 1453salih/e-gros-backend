package com.korkmaz.egrosbackend.product_management.application.services.category;

import com.korkmaz.egrosbackend.product_management.application.mapper.CategoryMapper;
import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.domain.repositories.CategoryRepository;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCategoryRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCategoryResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryServiceImpl implements CreateCategoryService {



    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CreateCategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public CreateCategoryResponse createCategory(CreateCategoryRequest request) {

        Category category = categoryMapper.toEntity(request);

        //* Parent kategori kontrolü eğer null veya 0 ise ana kategori olacak

        if (request.getParentId() != null && request.getParentId() > 0) {
            Category parentCategory = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent category not found with id: " + request.getParentId()));
            category.setParent(parentCategory);
        }

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toResponseDto(savedCategory);
    }

}
