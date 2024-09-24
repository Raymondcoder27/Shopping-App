package com.example.demo.stores.entity;

import com.example.demo.controller.payloads.CreateProduct;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;


//@Entity(name = "products")
@Entity
@Table(name = "products")
public class Product {

    @Id
    private UUID id;
    private UUID categoryId;
    private String name;
    private double price;
    private String description;
    private String size;
    private int quantity;

    public Product() {
    }

    public  Product(UUID id, UUID categoryId, String name, double price, String description,
                    String size, int quantity){
        this.id=id;
        this.categoryId=categoryId;
        this.name = name;
        this.price = price;
        this.description=description;
        this.size = size;
        this.quantity = quantity;
    }

    public Product(CreateProduct createProduct) {
        this.name = createProduct.getName();
        this.price = createProduct.getPrice();
        this.size = createProduct.getSize();
        this.quantity = createProduct.getQuantity();
        this.description = createProduct.getDescription();
    }



    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
