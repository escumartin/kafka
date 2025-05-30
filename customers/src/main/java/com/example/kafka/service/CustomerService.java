package com.example.kafka.service;


import com.example.kafka.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerEventsService customerEventsService;

    public Customer save(Customer customer) {
        System.out.println("Received " + customer);
        this.customerEventsService.publish(customer);
        return customer;
    }

}