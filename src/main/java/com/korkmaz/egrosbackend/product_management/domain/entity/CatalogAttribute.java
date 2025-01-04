package com.korkmaz.egrosbackend.product_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "catalog_attributes")
public class CatalogAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Catalog catalog;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private AttributeDefinition attributeDefinition;
    
    private String value;
}