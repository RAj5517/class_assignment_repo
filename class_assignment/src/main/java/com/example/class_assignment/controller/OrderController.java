package com.example.class_assignment.controller;

import com.example.class_assignment.dto.CreateOrderRequest;
import com.example.class_assignment.model.Order;
import com.example.class_assignment.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request.userId);
    }

    @GetMapping("/{orderId}")
    public Order get(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }
}
