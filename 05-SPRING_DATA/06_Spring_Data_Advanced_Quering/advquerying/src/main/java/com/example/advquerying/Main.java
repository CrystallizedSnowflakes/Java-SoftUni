package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Main implements CommandLineRunner {

    private final BufferedReader READER;
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.READER = new BufferedReader(new InputStreamReader(System.in));
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        getProblem();
    }

    private void getProblem() throws IOException {
        while (true) {
            System.out.println("Please enter exercise number (1-11) or 0 to exit:");
            var exercise = Integer.parseInt(READER.readLine());
            switch (exercise) {
                case 0 -> {return;}
                case 1 -> selectShampoosBySize();
                case 2 -> selectShampoosBySizeOrLabel();
                case 3 -> selectShampoosByPrice();
                case 4 -> selectIngredientsByName();
                case 5 -> selectIngredientsByNames();
                case 6 -> countShampoosByPrice();
                // JPQL Querying
                case 7 -> selectShampoosByIngredients();
                case 8 -> selectShampoosByIngredientsCount();
                case 9 -> deleteIngredientsByName();
                case 10 -> updateIngredientsByPrice();
                case 11 -> updateIngredientsByNames();
                default -> {
                    getProblem();
                }
            }
        }
    }

    private void updateIngredientsByNames() throws IOException {
        System.out.println("Task 11");
        System.out.println("Please enter price (1.2): ");
        BigDecimal priceFactor = new BigDecimal(READER.readLine());
        System.out.println("Please enter names (Berry Cherry): ");
        List<String> namesForUpdate = Arrays.asList(READER.readLine().split("\\s+"));
        System.out.println("CHANGED: " + this.ingredientService.updatePrice(priceFactor, namesForUpdate));
    }

    private void updateIngredientsByPrice() {
        System.out.println("Task 10");
        this.ingredientService.findAll()
                .stream().map(Ingredient::getPrice)
                .forEach(System.out::println);
        System.out.println("UPDATED: " + this.ingredientService.updatePrice());
        System.out.println("SUCCESS");
        this.ingredientService.findAll()
                .stream().map(Ingredient::getPrice)
                .forEach(System.out::println);
    }

    private void deleteIngredientsByName() throws IOException {
        System.out.println("Task 9");
        System.out.println("Please enter a name (nettle):");
        String nameToDelete = READER.readLine();
        this.ingredientService.deleteAllByName(nameToDelete);
        System.out.println("SUCCESS");
    }

    private void selectShampoosByIngredientsCount() throws IOException {
        System.out.println("Task 8");
        System.out.println("Please enter a number:");
        long number = Long.parseLong(READER.readLine());
        this.shampooService.findAllByIngredientsCountLessThan(number).forEach(System.out::println);
    }

    private void selectShampoosByIngredients() throws IOException {
        System.out.println("Task 7");
        System.out.println("Please enter ingredients names (Berry Mineral-Collagen)");
        List<String> names = Arrays.asList(READER.readLine().split("\\s+"));
        this.shampooService.findAllByIngredientsNames(names).forEach(System.out::println);
    }

    private void countShampoosByPrice() throws IOException {
        System.out.println("Task 6");
        System.out.println("Please enter price:");
        var price = new BigDecimal(READER.readLine());
        System.out.println(this.shampooService.countAllByPriceLessThan(price));
    }

    private void selectIngredientsByNames() throws IOException {
        System.out.println("Task 5");
        System.out.println("Please enter ingredient names (Lavender Herbs Apple):");
        List<String> names = Arrays.stream(READER.readLine().split("\\s+")).collect(Collectors.toList());
        this.ingredientService.findAllByNameIn(names).forEach(System.out::println);
    }

    private void selectIngredientsByName() throws IOException {
        System.out.println("Task 4");
        System.out.println("Please enter one letter:");
        String ingredientName = READER.readLine().toUpperCase();
        this.ingredientService.findAllByNameStartingWith(ingredientName).forEach(System.out::println);
    }

    private void selectShampoosByPrice() throws IOException {
        System.out.println("Task 3");
        System.out.println("Please enter price:");
        var price = new BigDecimal(READER.readLine());
        this.shampooService.findAllByPriceGreaterThanOrderByPriceDesc(price).forEach(System.out::println);
    }

    private void selectShampoosBySizeOrLabel() throws IOException {
        System.out.println("Task 2");
        System.out.println("Enter size (MEDIUM, SMALL, LARGE):");
        var size = Size.valueOf(READER.readLine().toUpperCase());
        System.out.println("Enter Label ID:");
        long labelId = Long.parseLong(READER.readLine());
        this.shampooService.findAllBySizeOrLabelOrderByPriceAsc(size, labelId).forEach(System.out::println);
    }

    private void selectShampoosBySize() throws IOException {
        System.out.println("Task 1");
        System.out.println("Enter size (MEDIUM, SMALL, LARGE):");
        var size = Size.valueOf(READER.readLine().toUpperCase());
        this.shampooService.findAllBySizeOrderById(size).forEach(System.out::println);
    }
}
