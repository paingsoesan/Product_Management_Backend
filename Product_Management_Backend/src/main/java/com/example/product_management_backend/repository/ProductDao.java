package com.example.product_management_backend.repository;

import com.example.product_management_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
