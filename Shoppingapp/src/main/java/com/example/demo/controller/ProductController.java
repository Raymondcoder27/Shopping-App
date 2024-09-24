package com.example.demo.controller;


import com.example.demo.contracts.DataResponse;
import com.example.demo.contracts.ProductResponse;
import com.example.demo.controller.payloads.CreateProduct;
import com.example.demo.service.ProductService;
import com.example.demo.stores.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/products")
public class  ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
//    public ResponseEntity<?> getAllProducts() {
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable UUID id) {
//        DataResponse productOptional = productService.getProductById(id);
//        if(productOptional.isPresent()){
            return ResponseEntity.ok(productService.getProductById(id));
//        }else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProduct createProduct) {
//        ProductResponse createdProduct = productService.createProduct(createProduct);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        return ResponseEntity.status(HttpStatus.OK).body(productService.createProduct(createProduct));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateProduct(@PathVariable UUID id, @RequestBody CreateProduct updatedProduct) {
//        Product updated = productService.updateProduct(id, updatedProduct);
//        if (updated != null) {
//            return ResponseEntity.ok(updated);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
//        productService.deleteProduct(id);
//        return ResponseEntity.ok().build();
//    }
}
