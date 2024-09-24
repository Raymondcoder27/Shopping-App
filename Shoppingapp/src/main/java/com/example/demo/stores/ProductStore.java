package com.example.demo.stores;

import com.example.demo.stores.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductStore {
    void persist(Product product);
    List<Product> getProducts();
    Optional<Product> getProduct(UUID id);

//    Optional<Product> getProduct(UUID id);
}
