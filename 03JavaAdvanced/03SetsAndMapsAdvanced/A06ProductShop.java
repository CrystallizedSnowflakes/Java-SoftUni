package bg.softuni.javaadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> costs = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("Revision")){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            costs.putIfAbsent(shop, new LinkedHashMap<>());
            costs.get(shop).put(product, price); // no double

            input = scanner.nextLine();
        }

        costs.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");
                    entry.getValue().entrySet()
                            .stream()
                            .forEach(innerEntry ->{
                                System.out.printf("Product: %s, Price: %.1f%n",
                                        innerEntry.getKey(), innerEntry.getValue());
                            });
                });
    }
}
