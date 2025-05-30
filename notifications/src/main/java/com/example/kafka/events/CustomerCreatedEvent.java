package com.example.kafka.events;

import com.example.kafka.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<Customer> {

}
