// service/CreateOrderService.java
package com.korkmaz.egrosbackend.order_management.application.services.order;

import com.korkmaz.egrosbackend.order_management.presentation.dto.request.CreateOrderRequest;
import com.korkmaz.egrosbackend.order_management.presentation.dto.response.OrderResponse;

public interface CreateOrderService {
    OrderResponse createOrder(CreateOrderRequest request);
}
