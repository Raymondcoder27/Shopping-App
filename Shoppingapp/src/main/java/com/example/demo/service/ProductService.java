package com.example.demo.service;

import com.example.demo.contracts.DataResponse;
import com.example.demo.contracts.ProductResponse;
import com.example.demo.controller.payloads.CreateProduct;
import com.example.demo.stores.entity.Product;
import com.example.demo.stores.sql.SqlProductStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private SqlProductStore store;

    public List<Product> getAllProducts() {
        return store.getProducts();
    }


    public DataResponse getProductById(UUID id) {
        var record = store.getProduct(id);
        if(record.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Product with id %s is not found", id));
        }
        return new DataResponse("Product found", record.get());
    }

    public ProductResponse createProduct(CreateProduct body) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(body.getName());
        product.setDescription(body.getDescription());
        product.setSize(body.getSize());
        product.setPrice(body.getPrice());
        product.setQuantity(body.getQuantity());
        store.persist(product);
        return new ProductResponse("Product created.", 200, product.getId());
    }

//    public Product createProduct(CreateProduct createProduct) {
//        Product product = new Product(createProduct);
//        return productRepository.save(product);
//    }

}
