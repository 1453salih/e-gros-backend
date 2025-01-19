package com.korkmaz.egrosbackend.order_management.domain.repositories;


import com.korkmaz.egrosbackend.order_management.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}