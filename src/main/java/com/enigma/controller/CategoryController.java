package com.enigma.controller;

import com.enigma.entity.Category;
import com.enigma.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin
    @GetMapping("/categories")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @CrossOrigin
    @GetMapping("/category/{idCategory}")
    public Category getCategoryById(@PathVariable String idCategory) {
        return categoryService.getCategoryById(idCategory);
    }

    @CrossOrigin
    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @CrossOrigin
    @PutMapping("/Category")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategoryById(category);
    }

    @CrossOrigin
    @DeleteMapping("/Category/{idCategory}")
    public void deleteCategory(@PathVariable String idCategory) {
        categoryService.deleteCategoryById(idCategory);
    }

}
