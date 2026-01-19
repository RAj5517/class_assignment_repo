package com.example.class_assignment.controller;

import com.example.class_assignment.dto.AddToCartRequest;
import com.example.class_assignment.model.CartItem;
import com.example.class_assignment.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public CartItem add(@RequestBody AddToCartRequest request) {
        CartItem item = new CartItem();
        item.setUserId(request.userId);
        item.setProductId(request.productId);
        item.setQuantity(request.quantity);
        return cartService.addToCart(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> get(@PathVariable String userId) {
        return cartService.getCartByUser(userId);
    }

    @DeleteMapping("/{userId}/clear")
    public String clear(@PathVariable String userId) {
        cartService.clearCart(userId);
        return "Cart cleared successfully";
    }
}
