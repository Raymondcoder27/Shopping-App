package com.example.demo.stores.sql;

import com.example.demo.stores.CategoryStore;
import com.example.demo.stores.entity.Category;
import com.example.demo.stores.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SqlCategoryStore implements CategoryStore {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void persist(Category category) {
      categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategory(UUID id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            categoryRepository.delete(category);
        }
    }
}
