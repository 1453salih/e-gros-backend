package com.korkmaz.egrosbackend.product_management.infrastructure.repositories;

import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;
import com.korkmaz.egrosbackend.product_management.domain.repositories.AttributeDefinitionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeDefinationRepositoryJPA  extends AttributeDefinitionRepository, JpaRepository<AttributeDefinition,Long> {
}
