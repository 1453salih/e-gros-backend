package com.korkmaz.egrosbackend.product_management.domain.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;



public interface AttributeDefinitionRepository {
    boolean existsByName(String name);
    AttributeDefinition save(AttributeDefinition attributeDefinition);
}
