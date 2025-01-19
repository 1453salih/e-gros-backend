package com.korkmaz.egrosbackend.order_management.application.services.order;

import com.korkmaz.egrosbackend.order_management.application.mapper.OrderMapper;
import com.korkmaz.egrosbackend.order_management.domain.entity.Order;
import com.korkmaz.egrosbackend.order_management.domain.entity.OrderItem;
import com.korkmaz.egrosbackend.order_management.infrastructure.config.RabbitMQConfig;
import com.korkmaz.egrosbackend.order_management.infrastructure.messaging.event.OrderCreatedEvent;
import com.korkmaz.egrosbackend.order_management.infrastructure.repositories.OrderRepositoryImpl;
import com.korkmaz.egrosbackend.order_management.presentation.dto.request.CreateOrderRequest;
import com.korkmaz.egrosbackend.order_management.presentation.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CreateOrderServiceImpl implements CreateOrderService {
    private final OrderRepositoryImpl orderRepository;
    private final ProductPriceService productPriceService;
    private final RabbitTemplate rabbitTemplate;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse createOrder(CreateOrderRequest orderDTO) {
        Order order = new Order();
        order.setCustomerId(orderDTO.getCustomerId());
        order.setShippingId(orderDTO.getShippingId());
        order.setPaymentId(orderDTO.getPaymentId());
        order.setStatus("PENDING");
        order.setOrderDate(LocalDateTime.now());

        // Ürün servisinden fiyatlarla sipariş oluşturma
        List<OrderItem> orderItems = orderDTO.getItems().stream()
                .map(itemDTO -> {
                    OrderItem item = new OrderItem();
                    item.setOrder(order);
                    item.setProductId(itemDTO.getProductId());
                    item.setQuantity(itemDTO.getQuantity());

                    // Get price from product service
                    Double unitPrice = productPriceService.getProductPrice(itemDTO.getProductId());
                    item.setUnitPrice(unitPrice);
                    item.setTotalPrice(unitPrice * itemDTO.getQuantity());

                    return item;
                })
                .collect(Collectors.toList());

        order.setItems(orderItems);

        // Toplam fiyat
        double totalPrice = orderItems.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
        order.setTotalPrice(totalPrice);

        // sipraiş kaydedilir

        Order savedOrder = orderRepository.save(order);

        // Publish event
        publishOrderCreatedEvent(savedOrder);

        return orderMapper.toResponse(savedOrder);
    }

    private void publishOrderCreatedEvent(Order order) {
        OrderCreatedEvent event = new OrderCreatedEvent(
                order.getId(),
                order.getCustomerId(),
                order.getOrderDate()
        );

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ORDER_CREATED_ROUTING_KEY,
                event
        );
    }
}