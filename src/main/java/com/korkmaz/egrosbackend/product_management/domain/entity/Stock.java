package com.korkmaz.egrosbackend.product_management.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    @Column(nullable = false)
    private Integer quantity;

    @NotNull(message = "Reserved quantity is required")
    @Min(value = 0, message = "Reserved quantity cannot be negative")
    @Column(nullable = false)
    private Integer reservedQuantity;

    private Integer availableQuantity;

    private LocalDateTime lastUpdated;

    @NotBlank(message = "Updated by field is required")
    private String updatedBy;

    @PrePersist
    @PreUpdate
    public void calculateAvailableQuantity() {
        this.availableQuantity = this.quantity - (this.reservedQuantity != null ? this.reservedQuantity : 0);
    }
}