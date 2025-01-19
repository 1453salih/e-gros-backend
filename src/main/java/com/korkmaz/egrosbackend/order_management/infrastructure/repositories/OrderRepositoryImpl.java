package com.korkmaz.egrosbackend.order_management.infrastructure.repositories;

import com.korkmaz.egrosbackend.order_management.domain.entity.Order;
import com.korkmaz.egrosbackend.order_management.domain.repositories.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryImpl extends JpaRepository <Order,Long>, OrderRepository {
}
