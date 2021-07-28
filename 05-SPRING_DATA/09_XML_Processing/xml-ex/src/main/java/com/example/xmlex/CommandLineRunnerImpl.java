package com.example.xmlex;

import com.example.xmlex.model.dto.categories.CategoryViewRootDto;
import com.example.xmlex.model.dto.inRange.ProductViewRootDto;
import com.example.xmlex.model.dto.seed.CategorySeedRootDto;
import com.example.xmlex.model.dto.seed.ProductSeedRootDto;
import com.example.xmlex.model.dto.seed.UserSeedRootDto;
import com.example.xmlex.model.dto.soldProducts.UserViewRootDto;
import com.example.xmlex.model.dto.users.UserAndProductsViewRootDto;
import com.example.xmlex.service.CategoryService;
import com.example.xmlex.service.ProductService;
import com.example.xmlex.service.UserService;
import com.example.xmlex.util.XMLParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final String RESOURCE_FILE_PATH = "src/main/resources/files/";
    private final String CATEGORIES_FILE_NAME = "categories.xml";
    private final String USERS_FILE_NAME = "users.xml";
    private final String PRODUCTS_FILE_NAME = "products.xml";

    private final String OUTPUT_FILE_PATH = "src/main/resources/files/out/";
    private final String PRODUCTS_IN_RANGE = "products-in-range.xml";
    private final String SOLD_PRODUCTS = "sold-products.xml";
    private final String CATEGORIES_BY_PRODUCTS = "categories-by-products.xml";
    private final String USERS_AND_PRODUCTS = "users-and-products.xml";

    private final XMLParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;


    public CommandLineRunnerImpl(XMLParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();

        System.out.println("Select exercise: ");
        int exNum = Integer.parseInt(bufferedReader.readLine());
        switch (exNum){
            case 1: productsInRange();
            case 2: usersWithSoldProducts();
            case 3: categoriesByProductsCount();
            case 4: usersAndProducts();
        }
    }

    private void usersAndProducts() throws JAXBException {
        UserAndProductsViewRootDto rootDto = this.userService
                .findAllUsersAndProductInfo();
        this.xmlParser.writeToFile(OUTPUT_FILE_PATH + USERS_AND_PRODUCTS, rootDto);

    }

    private void categoriesByProductsCount() throws JAXBException {
        CategoryViewRootDto rootDto = this.categoryService
                .findAllCategoriesOrderByProductsByCategory();
        this.xmlParser.writeToFile(OUTPUT_FILE_PATH + CATEGORIES_BY_PRODUCTS, rootDto);
    }

    private void usersWithSoldProducts() throws JAXBException {
        UserViewRootDto rootDto = this.userService
                .findUsersWithMoreThanOneSoldProduct();

        this.xmlParser.writeToFile(OUTPUT_FILE_PATH + SOLD_PRODUCTS, rootDto);
    }

    private void productsInRange() throws JAXBException {
        ProductViewRootDto rootDto = this.productService
                .findProductsInRangeWithNoBuyer();

        this.xmlParser.writeToFile(OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE, rootDto);
    }

    private void seedData() throws JAXBException, FileNotFoundException {

        if (this.categoryService.getEntityCount() == 0){
            CategorySeedRootDto categorySeedRootDto = this.xmlParser
                    .readFromFile(RESOURCE_FILE_PATH + CATEGORIES_FILE_NAME,
                            CategorySeedRootDto.class);

            this.categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (this.userService.getEntityCount() == 0){
            UserSeedRootDto userSeedRootDto = this.xmlParser
                    .readFromFile(RESOURCE_FILE_PATH + USERS_FILE_NAME,
                            UserSeedRootDto.class);
           this.userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (this.productService.getEntityCount() == 0){
            ProductSeedRootDto productSeedRootDto = this.xmlParser
                    .readFromFile(RESOURCE_FILE_PATH + PRODUCTS_FILE_NAME,
                            ProductSeedRootDto.class);

            this.productService.seedProducts(productSeedRootDto.getProducts());

        }
    }
}
