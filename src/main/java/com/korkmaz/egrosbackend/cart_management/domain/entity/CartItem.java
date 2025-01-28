package com.korkmaz.egrosbackend.cart_management.domain.entity;

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
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Long productId; // Ürün ID'si
    private Integer quantity; // Sepetteki ürün adedi
    private Double unitPrice; // Ürün birim fiyatı
    private Double totalPrice; // Toplam fiyat (quantity * unitPrice)
}
