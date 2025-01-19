package com.korkmaz.egrosbackend.order_management.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId; //* İd'ler foreign key şeklinde değil çünkü bağımlılık oluşturmak istemiyorum EDA(Event Driven Architecture) kullanılacak çünkü mikroservis'e geçiş
    private Long shippingId;
    private Long paymentId;

    @CreationTimestamp
    private LocalDateTime orderDate;

    private String status;
    private Double totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();
}
