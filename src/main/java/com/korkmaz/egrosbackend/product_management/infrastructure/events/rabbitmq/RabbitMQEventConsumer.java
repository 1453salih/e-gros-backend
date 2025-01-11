package com.korkmaz.egrosbackend.product_management.infrastructure.events.rabbitmq;

import com.korkmaz.egrosbackend.product_management.domain.events.ProductCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQEventConsumer {

    @RabbitListener(queues = "productQueue")
    public void handleProductCreatedEvent(ProductCreatedEvent event) {
        System.out.println("Received ProductCreatedEvent: " + event);
    }
}
