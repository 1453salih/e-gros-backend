package com.korkmaz.egrosbackend.product_management.domain.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeDefinitionRepository extends JpaRepository<AttributeDefinition,Long> {
}
