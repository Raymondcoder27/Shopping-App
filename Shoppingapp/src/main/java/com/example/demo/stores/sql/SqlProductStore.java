package com.example.demo.stores.sql;

import com.example.demo.stores.ProductStore;
import com.example.demo.stores.entity.Product;
import com.example.demo.stores.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SqlProductStore implements ProductStore {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void persist(Product product){
        productRepository.save(product);
    }

    @Override
    public List<Product> getProducts(){
       return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(UUID id) {
        return productRepository.findById(id);
    }


}
