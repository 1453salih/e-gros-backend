package com.korkmaz.egrosbackend.product_management.domain.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Attribute name is required")
    @Column(nullable = false, unique = true, length = 100)
    private String name;        // Renk, Beden, Malzeme, RAM, Ekran Boyutu vs.

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Attribute type is required")
    @Column(nullable = false)
    private AttributeType type;    // TEXT, NUMBER, BOOLEAN vs. Enum olabilir.

    @NotNull(message = "isRequired field is required")
    @Column(nullable = false)
    private Boolean isRequired;

    @NotNull(message = "isVariant field is required")
    @Column(nullable = false)
    private Boolean isVariant;

    @NotNull(message = "Sort order is required")
    @Column(nullable = false)
    private Integer sortOrder = 0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "attribute_category",
            joinColumns = @JoinColumn(name = "attribute_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
}