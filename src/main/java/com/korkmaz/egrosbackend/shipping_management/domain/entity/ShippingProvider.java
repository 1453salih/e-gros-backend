package com.korkmaz.egrosbackend.shipping_management.domain.entity;

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
@Table(name = "shipping_providers")
public class ShippingProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Sağlayıcı adı (ör. Aras, Yurtiçi, UPS)
    private String contactNumber; // Sağlayıcı iletişim numarası
    private String websiteUrl; // Sağlayıcı web sitesi URL'si
    private Boolean isActive; // Aktiflik durumu
}
