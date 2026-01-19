package com.example.class_assignment.repository;

import com.example.class_assignment.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PaymentRepository extends MongoRepository<Payment, String> {

    @Query("{ 'orderId' : ?0 }")
    Payment findByOrderId(String orderId);
}
