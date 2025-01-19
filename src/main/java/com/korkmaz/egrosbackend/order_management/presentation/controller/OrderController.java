package com.korkmaz.egrosbackend.order_management.presentation.controller;

import com.korkmaz.egrosbackend.order_management.application.services.order.CreateOrderService;
import com.korkmaz.egrosbackend.order_management.presentation.dto.request.CreateOrderRequest;
import com.korkmaz.egrosbackend.order_management.presentation.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final CreateOrderService createOrderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(createOrderService.createOrder(request));
    }
}