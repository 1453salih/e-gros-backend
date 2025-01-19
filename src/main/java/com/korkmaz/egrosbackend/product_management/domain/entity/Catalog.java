package com.korkmaz.egrosbackend.product_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
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
    
    private String barcode;
    private String sku;
    private BigDecimal salesPrice;
    private BigDecimal listPrice;
    private Integer stockQuantity;
    private Boolean isActive = true;
    
    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private List<CatalogImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private Set<CatalogAttribute> variantAttributes = new HashSet<>();
}