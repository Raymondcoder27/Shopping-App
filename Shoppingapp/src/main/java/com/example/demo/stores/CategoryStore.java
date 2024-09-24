package com.example.demo.stores;

import com.example.demo.stores.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryStore {
    void persist(Category category);
    List<Category> getCategories();
    Optional<Category> getCategory(UUID id);
    void deleteCategory(UUID id);
//    Optional<Category> deleteCategory(UUID id);
}
