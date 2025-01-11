package com.korkmaz.egrosbackend.product_management.infrastructure.events.rabbitmq;

import com.korkmaz.egrosbackend.product_management.domain.events.ProductCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishProductCreatedEvent(ProductCreatedEvent event) {
        rabbitTemplate.convertAndSend("productExchange", "productRoutingKey", event);
        System.out.println("ProductCreatedEvent sent: " + event);
    }
}
