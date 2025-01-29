package com.korkmaz.egrosbackend.product_management.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "catalogs")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @NotBlank(message = "Barcode is required")
    @Column(nullable = false, unique = true, length = 50)
    private String barcode;

    @NotBlank(message = "SKU is required")
    @Column(nullable = false, unique = true, length = 50)
    private String sku;

    @NotNull(message = "Sales price is required")
    @DecimalMin(value = "0.01", message = "Sales price must be greater than 0")
    @Column(nullable = false)
    private BigDecimal salesPrice;

    @NotNull(message = "List price is required")
    @DecimalMin(value = "0.01", message = "List price must be greater than 0")
    @Column(nullable = false)
    private BigDecimal listPrice;

    @NotNull(message = "isActive field is required")
    @Column(nullable = false)
    private Boolean isActive = true;

    
    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private List<CatalogImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private Set<CatalogAttribute> variantAttributes = new HashSet<>();

    @OneToOne(mappedBy = "catalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Stock stock;
}
