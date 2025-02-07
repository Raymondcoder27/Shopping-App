package com.example.demo.stores.repository;

import com.example.demo.stores.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
//    Optional<Product> findById(UUID id);
}
