package com.example.xmlex.service;

import com.example.xmlex.model.dto.seed.CategorySeedDto;
import com.example.xmlex.model.dto.categories.CategoryViewRootDto;
import com.example.xmlex.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    long getEntityCount();

    void seedCategories(List<CategorySeedDto> categories);

    Set<Category> getRandomCategories();

    CategoryViewRootDto findAllCategoriesOrderByProductsByCategory();
}
