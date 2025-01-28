package com.korkmaz.egrosbackend.payment_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_logs")
public class PaymentLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentId; // İlgili Payment kaydı
    private String logMessage; // Ödeme ile ilgili bilgi veya hata mesajı
    private LocalDateTime logDate; // Günlük tarihi
}
