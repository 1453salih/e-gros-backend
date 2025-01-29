package com.korkmaz.egrosbackend.product_management.application.services.attribute;

import com.korkmaz.egrosbackend.product_management.application.exception.AttributeAlreadyExistsException;
import com.korkmaz.egrosbackend.product_management.application.mapper.AttributeDefinitionMapper;
import com.korkmaz.egrosbackend.product_management.application.services.category.CategoryValidationService;
import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;


import com.korkmaz.egrosbackend.product_management.domain.entity.Category;
import com.korkmaz.egrosbackend.product_management.domain.repositories.AttributeDefinitionRepository;

import com.korkmaz.egrosbackend.product_management.domain.repositories.CategoryRepository;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateAttributeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeDefinitionRepository attributeDefinitionRepository;
    private final CategoryValidationService categoryValidationService;
    private final AttributeDefinitionMapper attributeDefinitionMapper;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public CreateAttributeResponse createAttribute(CreateAttributeRequest request) {

        //TODO:Ayrı bir serviste kontrol işlemi yapılabilir aöa gerek yok gibi


        // Kategori ID'lerinin doğruluğunu kontrol edilir
        categoryValidationService.validateCategoryIds(request.getCategoryIds());

        //Attribute mevcut mu kontrol edilir
        if (attributeDefinitionRepository.existsByName(request.getName())) {
            throw new AttributeAlreadyExistsException("Attribute with name " + request.getName() + " already exists");
        }

        // Request'i AttributeDefinition'a nesnesine
        AttributeDefinition attributeDefinition = attributeDefinitionMapper.toEntity(request);


        Set<Category> categories = new HashSet<>(categoryRepository.findAllById(request.getCategoryIds()));
        attributeDefinition.setCategories(categories);

        // Kayıt
        AttributeDefinition savedAttribute = attributeDefinitionRepository.save(attributeDefinition);

        // Response'a dönüştürülüp döndürür
        return attributeDefinitionMapper.toResponse(savedAttribute);
    }
}
