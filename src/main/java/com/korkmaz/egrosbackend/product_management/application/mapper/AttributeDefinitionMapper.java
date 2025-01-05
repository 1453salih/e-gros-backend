package com.korkmaz.egrosbackend.product_management.application.mapper;

import com.korkmaz.egrosbackend.product_management.application.dto.AttributeDefinitionDTO;
import com.korkmaz.egrosbackend.product_management.domain.entity.AttributeDefinition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeDefinitionMapper {
    AttributeDefinition toEntity(AttributeDefinitionDTO dto);
    AttributeDefinitionDTO toDto(AttributeDefinition entity);
}
