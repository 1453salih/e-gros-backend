package com.korkmaz.egrosbackend.payment_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String methodName; // Ödeme yöntemi adı (Kredi kartı, Eft)
    private String providerName; // Sağlayıcı adı ( Stripe, vb.)
    private Boolean isActive; // Aktiflik durumu
}
