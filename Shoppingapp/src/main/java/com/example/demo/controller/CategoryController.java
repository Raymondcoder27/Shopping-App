package com.example.demo.controller;

import com.example.demo.contracts.DataResponse;
import com.example.demo.controller.payloads.CreateCategory;
import com.example.demo.service.CategoryService;
import com.example.demo.stores.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable UUID id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CreateCategory body) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.createCategory(body));
    }


    @PutMapping("/{id}")
    public ResponseEntity<DataResponse> updateCategory(@PathVariable UUID id, @RequestBody Category updatedCategory) {
        DataResponse updated = categoryService.updateCategory(id, updatedCategory);

//        if (existingCategoryOptional.isPresent()) {
//            Category existingCategory = existingCategoryOptional.get();
//            existingCategory.setName(updatedCategory.getName());
//            Category updated = categoryService.updateCategory(id, updatedCategory);
            return ResponseEntity.ok(updated);
//        } else {
//            return ResponseEntity.notFound().build();
//        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
