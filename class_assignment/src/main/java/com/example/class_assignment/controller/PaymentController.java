package com.example.class_assignment.controller;

import com.example.class_assignment.dto.PaymentRequest;
import com.example.class_assignment.model.Payment;
import com.example.class_assignment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody PaymentRequest request) {
        return paymentService.createPayment(request.orderId, request.amount);
    }
}
