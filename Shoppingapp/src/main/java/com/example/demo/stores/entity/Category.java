package com.example.demo.stores.entity;

import jakarta.persistence.*;

import java.util.UUID;

//@Entity(name = "category")
@Entity
@Table(name = "category")
public class Category {
    @Id
    private UUID id;
    private String name;
    private String description;

    public Category() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
    this.id = id;
}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
