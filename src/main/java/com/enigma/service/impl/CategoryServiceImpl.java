package com.enigma.service.impl;

import com.enigma.constant.GeneratorConstant;
import com.enigma.entity.Category;
import com.enigma.entity.User;
import com.enigma.exception.DataNotFound;
import com.enigma.repository.CategoryRepository;
import com.enigma.service.CategoryService;
import com.enigma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategoryById(Category category) {
        Category getCategory = getCategoryById(category.getIdCategory());
        return saveCategory(category);
    }

    @Override
    public Category getCategoryById(String idCategory) {
        if (!categoryRepository.findById(idCategory).isPresent()){
            throw new DataNotFound(GeneratorConstant.ID_NOT_FOUND);
        }
        return categoryRepository.findById(idCategory).get();
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategoryById(String idCategory) {
        categoryRepository.deleteById(idCategory);
    }
}
