package com.korkmaz.egrosbackend.shipping_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipping_logs")
public class ShippingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    private String statusUpdate; // Güncelleme mesajı (ör. "Kargo yola çıktı")
    private LocalDateTime updateTime; // Güncelleme zamanı
}
