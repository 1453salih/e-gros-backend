package com.korkmaz.egrosbackend.payment_management.domain.entity;

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
@Table(name = "refunds")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentId; // İlgili Payment kaydı
    private Double refundAmount; // İade edilen tutar
    private String refundStatus; // Beklemede, Tamamlandı, Başarısız
    private String reason; // İade sebebi

    @CreationTimestamp
    private LocalDateTime refundDate; // İade tarihi
}
