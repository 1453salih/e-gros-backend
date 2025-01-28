package com.korkmaz.egrosbackend.product_management.application.services.attribute;

import com.korkmaz.egrosbackend.product_management.application.mapper.AttributeDefinitionMapper;
import com.korkmaz.egrosbackend.product_management.application.services.category.CategoryValidationService;
import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;


import com.korkmaz.egrosbackend.product_management.domain.repositories.AttributeDefinitionRepository;

import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateAttributeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeDefinitionRepository attributeDefinitionRepository;
    private final CategoryValidationService categoryValidationService;
    private final AttributeDefinitionMapper attributeDefinitionMapper;

    @Override
    @Transactional
    public CreateAttributeResponse createAttribute(CreateAttributeRequest request) {

        //TODO:Ayrı bir serviste kontrol işlemi yapılabilir aöa gerek yok gibi

        // Kategori ID'lerinin doğruluğunu kontrol edilir
        categoryValidationService.validateCategoryIds(request.getCategoryIds());

        // Request'i AttributeDefinition'a nesnesine
        AttributeDefinition attributeDefinition = attributeDefinitionMapper.toEntity(request);


        attributeDefinition.setCategories(
                attributeDefinitionMapper.mapCategoryIds(request.getCategoryIds())
        );

        // Kayıt
        AttributeDefinition savedAttribute = attributeDefinitionRepository.save(attributeDefinition);

        // Response'a dönüştürülüp döndürür
        return attributeDefinitionMapper.toResponse(savedAttribute);
    }
}
