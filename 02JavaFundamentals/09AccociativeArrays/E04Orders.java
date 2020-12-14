package bg.softuni.javafundamentals;

import java.util.*;

public class E04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Double> productsAndPrices = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productsAndQuantity = new LinkedHashMap<>();

        while (true){
            String[] productParameters = scanner.nextLine().split("\\s+");
            if ("buy".equals(productParameters[0])){
                break;
            }
            String name = productParameters[0];
            double price = Double.parseDouble(productParameters[1]);
            int quantity = Integer.parseInt(productParameters[2]);

            Integer currentQuantity = productsAndQuantity.get(name);
            if (currentQuantity == null){
                currentQuantity = 0;
            }
            productsAndQuantity.put(name, currentQuantity + quantity);

            double currentPrice = 0.0;
            if (currentPrice != price){
                currentPrice = price;
            }
            productsAndPrices.put(name, currentPrice * (currentQuantity + quantity));
        }

        /*for (Map.Entry<String, Double> entry : productsAndPrices.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }*/

        productsAndPrices.forEach((key, value) ->
                System.out.println(String.format("%s -> %.2f", key, value)));
    }
}
