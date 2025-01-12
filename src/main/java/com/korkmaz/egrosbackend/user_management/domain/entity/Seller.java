package com.korkmaz.egrosbackend.user_management.domain.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User {
    private String storeName;
    private String iban;
}
