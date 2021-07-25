package com.example.json_exercise.service;

import com.example.json_exercise.model.dto.CategoryByProductsCountDto;
import com.example.json_exercise.model.entity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();

    List<CategoryByProductsCountDto> findAllCategoriesInfoByProductsCount();
}
