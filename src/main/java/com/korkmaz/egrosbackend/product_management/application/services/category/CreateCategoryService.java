package com.korkmaz.egrosbackend.product_management.application.services.category;

import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCategoryRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCategoryResponse;
import org.springframework.stereotype.Service;

@Service
public interface CreateCategoryService {
    CreateCategoryResponse createCategory(CreateCategoryRequest request);
}
