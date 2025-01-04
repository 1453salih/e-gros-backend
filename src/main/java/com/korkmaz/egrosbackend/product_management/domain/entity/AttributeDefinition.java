package com.korkmaz.egrosbackend.product_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attribute_definitions")
public class AttributeDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;        // Renk, Beden, Malzeme, RAM, Ekran Boyutu vs.
    private String type;        // TEXT, NUMBER, BOOLEAN vs.
    private Boolean isRequired;
    private Boolean isVariant;
    private Integer sortOrder;
    
    @ManyToMany
    private Set<Category> categories = new HashSet<>();  // Hangi kategorilerde kullanılacağını tutar
}