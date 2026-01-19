# Minimal E-Commerce Backend API (Spring Boot + MongoDB)

This project is a minimal e-commerce backend system built using Spring Boot and MongoDB as part of an in-class assignment.  
It demonstrates REST APIs, database persistence, business logic, and webhook-based payment handling.

---

## Objective

The system supports a complete purchase flow:

- Create and list products
- Add items to a user cart
- Create orders from cart
- Initiate payments (mock payment service)
- Process payment webhooks
- Update order status after payment

All APIs are tested using Postman.

---

## Tech Stack

- Java 17+
- Spring Boot 3.2.x
- Spring Web (REST APIs)
- Spring Data MongoDB
- MongoDB
- Postman (API testing)

---

## Project Structure

src/main/java/com/example/class_assignment
│
├── ClassAssignmentApplication.java
│
├── controller
│   ├── ProductController.java
│   ├── CartController.java
│   ├── OrderController.java
│   └── PaymentController.java
│
├── service
│   ├── ProductService.java
│   ├── CartService.java
│   ├── OrderService.java
│   └── PaymentService.java
│
├── repository
│   ├── ProductRepository.java
│   ├── CartRepository.java
│   ├── OrderRepository.java
│   ├── OrderItemRepository.java
│   └── PaymentRepository.java
│
├── model
│   ├── User.java
│   ├── Product.java
│   ├── CartItem.java
│   ├── Order.java
│   ├── OrderItem.java
│   └── Payment.java
│
├── dto
│   ├── AddToCartRequest.java
│   ├── CreateOrderRequest.java
│   ├── PaymentRequest.java
│   └── PaymentWebhookRequest.java
│
└── webhook
    └── PaymentWebhookController.java

---

## Database Entities

- User
- Product
- CartItem
- Order
- OrderItem
- Payment

MongoDB collections are automatically created by Spring Data MongoDB.

---

## Base URL

http://localhost:8080

---

## API Endpoints

### Product APIs

Create Product  
POST /api/products

Request Body:
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000,
  "stock": 10
}

Get All Products  
GET /api/products

---

### Cart APIs

Add Item to Cart  
POST /api/cart/add

Request Body:
{
  "userId": "user123",
  "productId": "<productId>",
  "quantity": 2
}

Get User Cart  
GET /api/cart/{userId}

Clear Cart  
DELETE /api/cart/{userId}/clear

---

### Order APIs

Create Order (from cart)  
POST /api/orders

Request Body:
{
  "userId": "user123"
}

Get Order Details  
GET /api/orders/{orderId}

---

### Payment APIs (Mock Payment)

Create Payment  
POST /api/payments/create

Request Body:
{
  "orderId": "<orderId>",
  "amount": 100000
}

---

### Webhook API (Payment Callback)

Simulate Payment Success  
POST /api/webhooks/payment

Request Body:
{
  "orderId": "<orderId>",
  "status": "SUCCESS"
}

This updates:
- Payment status to SUCCESS
- Order status to PAID

---

## Complete Order Flow

1. Create products
2. Add products to cart
3. View cart
4. Create order from cart
5. Initiate payment
6. Trigger payment webhook
7. Verify order status updated to PAID

---

## Configuration

application.properties

spring.data.mongodb.uri=mongodb://localhost:27017/class_assignment
server.port=8080

MongoDB must be running on localhost:27017.

---

## How to Run the Project

1. Start MongoDB
2. Open the project in IntelliJ IDEA
3. Reload Maven dependencies
4. Run ClassAssignmentApplication.java
5. Server starts on port 8080

---

## Testing

All APIs are tested using Postman in the following order:

POST   /api/products  
GET    /api/products  
POST   /api/cart/add  
GET    /api/cart/{userId}  
POST   /api/orders  
POST   /api/payments/create  
POST   /api/webhooks/payment  
GET    /api/orders/{orderId}

---

## Key Concepts Demonstrated

- RESTful API design
- Spring Boot auto-configuration
- MongoDB repositories
- Service-layer business logic
- Cart to order conversion
- Webhook-based payment handling
- Order state management

---

## Final Status

- All required APIs implemented
- Complete order flow working
- Payment webhook updates order status
- Ready for demo, viva, and grading
