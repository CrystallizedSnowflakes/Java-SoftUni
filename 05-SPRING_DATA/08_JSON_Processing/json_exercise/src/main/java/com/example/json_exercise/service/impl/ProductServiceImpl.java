package com.example.json_exercise.service.impl;

import com.example.json_exercise.model.dto.ProductWithSellerDto;
import com.example.json_exercise.model.dto.ProductSeedDto;
import com.example.json_exercise.model.entity.Product;
import com.example.json_exercise.repository.ProductRepository;
import com.example.json_exercise.service.CategoryService;
import com.example.json_exercise.service.ProductService;
import com.example.json_exercise.service.UserService;
import com.example.json_exercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.json_exercise.constants.GlobalConstants.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {

        if (this.productRepository.count() > 0){
            return;
        }

        String fileContent = Files
                .readString(Path.of(RESOURCE_FILE_PATH + FROM_PRODUCTS_FILE));

        ProductSeedDto[] productSeedDTOs = this.gson
                .fromJson(fileContent, ProductSeedDto[].class);

        List<Product> products = Arrays
                .stream(productSeedDTOs)
                .filter(this.validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = this.modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(this.userService.findRandomUser());
                    if (product.getPrice().compareTo(BigDecimal.valueOf(900L)) > 0) {
                        product.setBuyer(this.userService.findRandomUser());
                    }
                    product.setCategories(this.categoryService.findRandomCategories());
                    return product;
                })
                .collect(Collectors.toList());
        System.out.println();
        products.forEach(productRepository::save);
    }

    @Override
    public List<ProductWithSellerDto> findAllProductsInRangeWithNoBuyerOrderByPrice(BigDecimal lower, BigDecimal upper) {
        return this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lower, upper)
                .stream()
                .map(product -> {
                    ProductWithSellerDto productWithSellerDto = this.modelMapper
                            .map(product, ProductWithSellerDto.class);

                    productWithSellerDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));

                    return productWithSellerDto;
                })
                .collect(Collectors.toList());
    }
}
