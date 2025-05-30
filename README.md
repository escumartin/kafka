# Example of Communication Between Microservices Using Apache Kafka

This project consists of two independent microservices: one is a **producer** and the other is a **Kafka consumer**.

It simulates a microservice called **Customers** (publisher) and another called **Notifications** (consumer).

The purpose is to provide a basic example demonstrating how asynchronous communication works with Kafka. When a ‘Customer’ is created via the REST API in the Customers service, an event is sent asynchronously through Apache Kafka to the Notifications service. This allows the Notifications service to use this data as needed.
