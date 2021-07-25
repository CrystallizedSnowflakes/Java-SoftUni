package com.example.json_exercise;

import com.example.json_exercise.constants.GlobalConstants;
import com.example.json_exercise.model.dto.CategoryByProductsCountDto;
import com.example.json_exercise.model.dto.ProductWithSellerDto;
import com.example.json_exercise.model.dto.UserSoldDto;
import com.example.json_exercise.model.dto.UsersCountAndUserInfoDto;
import com.example.json_exercise.service.CategoryService;
import com.example.json_exercise.service.ProductService;
import com.example.json_exercise.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        seedDate();

        System.out.println("Please Enter Exercise from 1 to 4:");
        int exNum = Integer.parseInt(bufferedReader.readLine());
        switch (exNum){
            case 1 -> productsInRange();
            case 2 -> soldProducts();
            case 3 -> categoriesByProductsCount();
            case 4 -> usersAndProducts();
            default -> System.out.println("Invalid exercise number.");
        }
    }

    private void usersAndProducts() throws IOException {
        UsersCountAndUserInfoDto allUsersWithAtLeastOneSoldProductOrderByProductsCountDescThenByLastName = userService.findAllUsersWithAtLeastOneSoldProductOrderByProductsCountDescThenByLastName();

        String content = gson
                .toJson(allUsersWithAtLeastOneSoldProductOrderByProductsCountDescThenByLastName);

        writeToFile(GlobalConstants.TO_USERS_AND_PRODUCTS_FILE, content);
    }

    private void categoriesByProductsCount() throws IOException {
        List<CategoryByProductsCountDto> categoryByProductsCountDTOs = categoryService
                .findAllCategoriesInfoByProductsCount();

        String content = gson
                .toJson(categoryByProductsCountDTOs);

        writeToFile(GlobalConstants.TO_CATEGORIES_BY_PRODUCTS_COUNT_FILE, content);
    }

    private void soldProducts() throws IOException {
        List<UserSoldDto> userSoldDTOs = userService
                .findAllUsersWithAtLeastOneSoldProductOrderByLastNameThenByFirstName();

        String content = gson
                .toJson(userSoldDTOs);

        writeToFile(GlobalConstants.TO_USERS_AND_SOLD_PRODUCTS_FILE, content);
    }

    private void productsInRange() throws IOException {

        List<ProductWithSellerDto> productDTOs = productService
                .findAllProductsInRangeWithNoBuyerOrderByPrice(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

        String content = gson.toJson(productDTOs);
        writeToFile(GlobalConstants.TO_PRODUCT_IN_RANGE_FILE, content);

    }

    private void writeToFile(String fileName, String content) throws IOException {
        Files
                .write(Path.of(GlobalConstants.OUTPUT_FILE_PATH + fileName),
                        Collections.singleton(content));
    }

    private void seedDate() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();
    }
}
