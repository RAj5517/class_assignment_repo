package com.example.class_assignment.repository;

import com.example.class_assignment.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {}
