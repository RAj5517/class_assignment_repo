package com.example.class_assignment.webhook;

import com.example.class_assignment.dto.PaymentWebhookRequest;
import com.example.class_assignment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks/payment")
public class PaymentWebhookController {

    private final PaymentService paymentService;

    public PaymentWebhookController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void webhook(@RequestBody PaymentWebhookRequest request) {
        if ("SUCCESS".equals(request.status)) {
            paymentService.completePayment(request.orderId);
        }
    }
}
