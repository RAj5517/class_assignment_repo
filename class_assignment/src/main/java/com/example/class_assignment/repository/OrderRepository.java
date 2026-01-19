package com.example.class_assignment.repository;

import com.example.class_assignment.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {}
