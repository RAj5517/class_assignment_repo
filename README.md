Minimal E-Commerce Backend API (Spring Boot + MongoDB)

This project is a minimal e-commerce backend system built using Spring Boot and MongoDB as part of an in-class assignment.
It demonstrates core backend concepts such as REST APIs, database persistence, business logic, and webhook-based payment handling.

🎯 Objective

The system supports a complete purchase flow:

✅ Create and list products

✅ Add items to a user cart

✅ Create orders from cart

✅ Initiate payments (mock payment service)

✅ Process payment webhooks

✅ Update order status after payment

All APIs are tested using Postman.

🏗️ Tech Stack

Java 17+

Spring Boot 3.2.x

Spring Web (REST APIs)

Spring Data MongoDB

MongoDB

Postman (API testing)

📁 Project Structure
src/main/java/com/example/class_assignment
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

🗄️ Database Schema (Entities)

User → represents application users

Product → items available for purchase

CartItem → items added to user cart

Order → order created from cart

OrderItem → products inside an order

Payment → payment information for an order

MongoDB collections are automatically created by Spring Data.

🌐 Base URL
http://localhost:8080

🔗 API Endpoints
1️⃣ Product APIs
Create Product
POST /api/products

{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000,
  "stock": 10
}

Get All Products
GET /api/products

2️⃣ Cart APIs
Add Item to Cart
POST /api/cart/add

{
  "userId": "user123",
  "productId": "<productId>",
  "quantity": 2
}

Get User Cart
GET /api/cart/{userId}

Clear Cart
DELETE /api/cart/{userId}/clear

3️⃣ Order APIs
Create Order (from cart)
POST /api/orders

{
  "userId": "user123"
}

Get Order Details
GET /api/orders/{orderId}

4️⃣ Payment APIs (Mock Payment)
Create Payment
POST /api/payments/create

{
  "orderId": "<orderId>",
  "amount": 100000
}

5️⃣ Webhook API (Payment Callback)
Simulate Payment Success
POST /api/webhooks/payment

{
  "orderId": "<orderId>",
  "status": "SUCCESS"
}


Updates Payment → SUCCESS

Updates Order → PAID

🔄 Complete Order Flow

Create products

Add products to cart

View cart

Create order from cart

Initiate payment

Trigger webhook (payment success)

Verify order status updated to PAID

⚙️ Configuration
application.properties
spring.data.mongodb.uri=mongodb://localhost:27017/class_assignment
server.port=8080


MongoDB must be running on localhost:27017.

▶️ How to Run the Project

Start MongoDB

Open project in IntelliJ IDEA

Reload Maven dependencies

Run:

ClassAssignmentApplication.java


Server starts at:

http://localhost:8080

🧪 Testing

All APIs are tested using Postman following the sequence:

POST   /api/products
GET    /api/products
POST   /api/cart/add
GET    /api/cart/{userId}
POST   /api/orders
POST   /api/payments/create
POST   /api/webhooks/payment
GET    /api/orders/{orderId}

🎓 Key Concepts Demonstrated

RESTful API design

Spring Boot auto-configuration

MongoDB repositories

Service-layer business logic

Cart → Order conversion

Webhook-based payment handling

Order state management

🏁 Final Status

✅ All required APIs implemented
✅ Order flow working end-to-end
✅ Payment webhook updates order status
✅ Ready for demo, viva, and grading