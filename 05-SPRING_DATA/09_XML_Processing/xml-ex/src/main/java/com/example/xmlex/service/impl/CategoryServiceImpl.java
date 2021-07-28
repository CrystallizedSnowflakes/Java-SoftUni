package com.example.xmlex.service.impl;

import com.example.xmlex.model.dto.categories.CategoryInfoDto;
import com.example.xmlex.model.dto.seed.CategorySeedDto;
import com.example.xmlex.model.dto.categories.CategoryViewRootDto;
import com.example.xmlex.model.entity.Category;
import com.example.xmlex.model.entity.Product;
import com.example.xmlex.repository.CategoryRepository;
import com.example.xmlex.service.CategoryService;
import com.example.xmlex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {

        categories
                .stream()
                .filter(this.validationUtil::isValid)
                .map(categorySeedDto -> this.modelMapper.map(categorySeedDto, Category.class))
                .forEach(this.categoryRepository::save);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        long categoriesCount = this.categoryRepository.count();
        for (int i = 0; i < 2; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, categoriesCount);
            categories.add(this.categoryRepository.findById(randomId).orElse(null));
        }
        return categories;
    }

    @Override
    public CategoryViewRootDto findAllCategoriesOrderByProductsByCategory() {
        CategoryViewRootDto categoryViewRootDto = new CategoryViewRootDto();

        categoryViewRootDto
                .setCategories(this.categoryRepository
                .findAllCategoriesOrderByProductsCount()
                .stream()
                .map(category -> {
                    CategoryInfoDto infoDto = this.modelMapper.map(category, CategoryInfoDto.class);
                    BigDecimal averagePrice = BigDecimal.ZERO;
                    BigDecimal totalPriceSum = BigDecimal.ZERO;
                    int productsCount = category.getProducts().size();
                    if (productsCount != 0) {
                        totalPriceSum = category.getProducts().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
                        averagePrice = totalPriceSum.divide(BigDecimal.valueOf(productsCount), 6, RoundingMode.FLOOR);
                    }
                    infoDto.setProductsCount(productsCount);
                    infoDto.setAveragePrice(averagePrice);
                    infoDto.setTotalRevenue(totalPriceSum);
                    return infoDto;
                }).collect(Collectors.toList()));

        System.out.println();

        return categoryViewRootDto;
    }

    @Override
    public long getEntityCount() {
        return this.categoryRepository.count();
    }
}
