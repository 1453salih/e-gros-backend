package com.korkmaz.egrosbackend.product_management.infrastructure.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String PRODUCT_QUEUE = "productQueue";
    public static final String PRODUCT_EXCHANGE = "productExchange";
    public static final String PRODUCT_ROUTING_KEY = "productRoutingKey";

    @Bean
    public Queue productQueue() {
        return new Queue(PRODUCT_QUEUE, true); // Durable kuyruk
    }

    @Bean
    public DirectExchange productExchange() {
        return new DirectExchange(PRODUCT_EXCHANGE);
    }

    @Bean
    public Binding productBinding(Queue productQueue, DirectExchange productExchange) {
        return BindingBuilder.bind(productQueue).to(productExchange).with(PRODUCT_ROUTING_KEY);
    }
}
