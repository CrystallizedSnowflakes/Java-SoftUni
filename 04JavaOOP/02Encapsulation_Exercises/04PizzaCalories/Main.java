package e04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaTokens = scanner.nextLine().split("\\s+");
        String[] doughTokens = scanner.nextLine().split("\\s+");

        Pizza pizza = null;
        try {
            String pizzaName = pizzaTokens[1];
            int countOfToppings = Integer.parseInt(pizzaTokens[2]);
            pizza = new Pizza(pizzaName, countOfToppings);

            String flourType = doughTokens[1];
            String bakingTechnique = doughTokens[2];
            double doughWeight = Double.parseDouble(doughTokens[3]);
            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);

            pizza.setDough(dough);

            for (int i = 0; i < countOfToppings; i++) {
                String[] toppingTokens = scanner.nextLine().split("\\s+");
                String toppingName = toppingTokens[1];
                double toppingWeight = Double.parseDouble(toppingTokens[2]);
                Topping topping = new Topping(toppingName, toppingWeight);

                pizza.addTopping(topping);
            }

        } catch (IllegalArgumentException ex){
            System.err.println(ex.getMessage());
            return;
        }

        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
    }
}
