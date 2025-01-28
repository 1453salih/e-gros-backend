package com.korkmaz.egrosbackend.payment_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private String paymentMethod; // Kredi Kartı, Eft, vb.
    private String paymentStatus; // Paid, Failed, Pending, etc.
    private Double amount; // Ödeme tutarı
    private String transactionId; // Ödeme sağlayıcısından alınan işlem ID'si

    @CreationTimestamp
    private LocalDateTime transactionDate;
}
