package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.CategoryDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateCategoryRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateCategoryResponse;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "parent", ignore = true)
    Category toEntity(CreateCategoryRequest request);

    @Mapping(target = "subCategoryIds", expression = "java(mapSubCategoryIds(category))")
    CategoryDTO toDto(Category category);

    // Özel method  mapping sub-category IDs için
    default List<Long> mapSubCategoryIds(Category category) {
        if (category.getSubCategories() == null) {
            return null;
        }
        return category.getSubCategories()
                .stream()
                .map(Category::getId)
                .collect(Collectors.toList());
    }
    CreateCategoryResponse toResponseDto(Category category);
}
