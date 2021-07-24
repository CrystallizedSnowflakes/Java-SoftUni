package com.example.bookshop_system.service;

import com.example.bookshop_system.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
