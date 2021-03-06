package com.hgaspar.calculator.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
	
	
    public static final String QUEUE_IN = "calculator.queue.in";
    public static final String EXCHANGE = "calculator_exchange";
    public static final String ROUTING_KEY = "calculator_routingKey";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_IN);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean(name="converter")
    public MessageConverter converter() {
    	
    

    return new Jackson2JsonMessageConverter();
    }
    

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
   
       
        
        return rabbitTemplate;
    }

}

