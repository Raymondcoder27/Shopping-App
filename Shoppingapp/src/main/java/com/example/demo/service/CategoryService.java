package com.example.demo.service;

import com.example.demo.contracts.CategoryResponse;
import com.example.demo.contracts.DataResponse;
import com.example.demo.controller.payloads.CreateCategory;
import com.example.demo.stores.entity.Category;
import com.example.demo.stores.sql.SqlCategoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CategoryService {

    @Autowired
    private SqlCategoryStore store;

    public List<Category> getAllCategories() {
        return store.getCategories();
    }

    public DataResponse getCategoryById(UUID id) {
        var record = store.getCategory(id);
        if(record.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Category with id %s is not found.", id));
        }
        return new DataResponse("Category found", record.get());
    }

    public CategoryResponse createCategory(CreateCategory body) {
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName(body.getName());
        category.setDescription(body.getDescription());
        store.persist(category);
        return new CategoryResponse("Category Created", 200, category.getId());
    }



    public DataResponse updateCategory(UUID id, Category updatedCategory) {
        // Retrieve the category by ID
        var categoryOptional = store.getCategory(id);

        // Check if the category exists
        if (categoryOptional.isEmpty()) {
            // If the category does not exist, throw an exception with status code 400
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Category with id %s does not exist.", id));
        }

        // Get the existing category from the optional
        Category existingCategory = categoryOptional.get();

        // Update the existing category with the new values
        existingCategory.setName(updatedCategory.getName());

        // Persist the updated category
        store.persist(existingCategory);

        // Return the updated category
        return new DataResponse("Category Updated",existingCategory );
    }







    public void deleteCategory(UUID id) {
        // Retrieve the category by ID
        var categoryOptional = store.getCategory(id);

        // Check if the category exists
        if (categoryOptional.isEmpty()) {
            // If the category does not exist, throw an exception with status code 400
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Category with id %s does not exist.", id));
        }

        // If the category exists, delete it from the store
        store.deleteCategory(id);
    }
}
