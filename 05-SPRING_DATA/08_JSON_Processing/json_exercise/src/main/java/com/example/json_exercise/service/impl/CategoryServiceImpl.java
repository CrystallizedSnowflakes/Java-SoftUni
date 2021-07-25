package com.example.json_exercise.service.impl;

import com.example.json_exercise.model.dto.CategoryByProductsCountDto;
import com.example.json_exercise.model.dto.CategorySeedDto;
import com.example.json_exercise.model.entity.Category;
import com.example.json_exercise.model.entity.Product;
import com.example.json_exercise.repository.CategoryRepository;
import com.example.json_exercise.service.CategoryService;
import com.example.json_exercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.json_exercise.constants.GlobalConstants.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {

        if (this.categoryRepository.count() > 0){
            return;
        }

        String fileContent = Files
                .readString(
                        Path.of(RESOURCE_FILE_PATH + FROM_CATEGORIES_FILE));

        // return Array from DTOs via gson from String
        CategorySeedDto[] categorySeedDTOs = this.gson
                .fromJson(fileContent, CategorySeedDto[].class);

        // save in DB
        Arrays.stream(categorySeedDTOs)
                .filter(this.validationUtil::isValid)
                .map(categorySeedDto -> this.modelMapper.map(categorySeedDto, Category.class))
                .forEach(this.categoryRepository::save);
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int countOfCategories = ThreadLocalRandom.current().nextInt(1, 3);
        long totalCategoriesCount = this.categoryRepository.count();
        for (int i = 0; i < countOfCategories; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, totalCategoriesCount + 1);
            categories.add(this.categoryRepository.findById(randomId).orElse(null));
        }
        return categories;
    }

    @Override
    public List<CategoryByProductsCountDto> findAllCategoriesInfoByProductsCount() {
        List<Category> allCategoriesOrderByProductsCount = this.categoryRepository.findAllCategoriesOrderByProductsCount();
        if (allCategoriesOrderByProductsCount == null){
            System.out.println("There is no categories in DB");
            return null;
        }
        List<CategoryByProductsCountDto> DTOs = allCategoriesOrderByProductsCount
                .stream()
                .map(category -> {
                    CategoryByProductsCountDto dto = this.modelMapper.map(category, CategoryByProductsCountDto.class);
                    BigDecimal averagePrice = BigDecimal.ZERO;
                    BigDecimal totalPriceSum = BigDecimal.ZERO;
                    int productsCount = category.getProducts().size();
                    if (productsCount != 0){
                        totalPriceSum = category.getProducts().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
                        averagePrice = totalPriceSum.divide(BigDecimal.valueOf(productsCount), 6, RoundingMode.FLOOR);
                    }
                    dto.setProductsCount(productsCount);
                    dto.setAveragePrice(averagePrice);
                    dto.setTotalRevenue(totalPriceSum);
                    return dto;
                })
                .collect(Collectors.toList());
        return DTOs;
    }
}
