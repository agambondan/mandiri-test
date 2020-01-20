package com.enigma.service;

import com.enigma.entity.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    Category updateCategoryById(Category category);

    Category getCategoryById(String idCategory);

    List<Category> getAllCategory();

    void deleteCategoryById(String idCategory);
}
