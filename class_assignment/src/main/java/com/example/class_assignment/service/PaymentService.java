package com.example.class_assignment.service;

import com.example.class_assignment.model.Order;
import com.example.class_assignment.model.Payment;
import com.example.class_assignment.repository.OrderRepository;
import com.example.class_assignment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public Payment createPayment(String orderId, Double amount) {
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setStatus("PENDING");
        payment.setPaymentId("pay_" + UUID.randomUUID());
        payment.setCreatedAt(Instant.now());
        return paymentRepository.save(payment);
    }

    public void completePayment(String orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId);
        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);

        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus("PAID");
        orderRepository.save(order);
    }
}
