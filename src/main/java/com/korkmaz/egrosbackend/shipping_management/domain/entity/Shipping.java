package com.korkmaz.egrosbackend.shipping_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shippings")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private String shippingMethod; // Standart, Ekspres, vb.
    private String trackingNumber; // Kargo takip numarası
    private String shippingStatus; // Beklemede, Sevk Edildi, Teslim Edildi, vb.

    @CreationTimestamp
    private LocalDateTime createdAt; // Kargo oluşturulma tarihi

    private LocalDateTime estimatedDeliveryDate; // Tahmini teslimat tarihi
    private LocalDateTime actualDeliveryDate; // Gerçek teslimat tarihi
}
