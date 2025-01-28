package com.korkmaz.egrosbackend.product_management.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attribute_definitions")
public class AttributeDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;        // Renk, Beden, Malzeme, RAM, Ekran Boyutu vs.
    private String type;        // TEXT, NUMBER, BOOLEAN vs. Enum olabilir.
    private Boolean isRequired;
    private Boolean isVariant;
    private Integer sortOrder;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Category> categories = new HashSet<>();
}