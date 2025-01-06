package com.korkmaz.egrosbackend.product_management.application.services;

import com.korkmaz.egrosbackend.product_management.application.dto.CategoryDTO;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCategoryRequest;
import org.springframework.stereotype.Service;

@Service
public interface AddCategoryService {
    CategoryDTO addCategory(CreateCategoryRequest request);
}
