package com.example.kafka.service;


import com.example.kafka.entity.Customer;
import com.example.kafka.events.CustomerCreatedEvent;
import com.example.kafka.events.Event;
import com.example.kafka.events.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CustomerEventsService {

    private final KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name:customers}")
    private String topicCustomer;

    public void publish(Customer customer) {

        CustomerCreatedEvent created = new CustomerCreatedEvent();
        created.setData(customer);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCustomer, created);
    }


}