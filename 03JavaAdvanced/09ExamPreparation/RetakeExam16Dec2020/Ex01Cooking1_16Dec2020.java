package bg.softuni.javaadvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Ex01Cooking1_16Dec2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        Map<String, Integer> productsCooked = new TreeMap<>();
        cookingTable.values()
                .forEach(p -> productsCooked.put(p, 0));

        // Queue
        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // add()

        // Stack
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsStack::push);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){
            int currentLiquid = liquidsQueue.poll();
            int currentIngredient = ingredientsStack.pop();

            int sum = currentLiquid + currentIngredient;
            if (ableToCookProduct(sum)){
                String product = cookingTable.get(sum);
                productsCooked.put(product, productsCooked.get(product) + 1);

            }else {
                int increasedIngredient = currentIngredient + 3;
                ingredientsStack.push(increasedIngredient);
            }
        }

        if (hasCookedEachMeal(productsCooked)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getElementsInfo(liquidsQueue));
        System.out.println("Ingredients left: " + getElementsInfo(ingredientsStack));
        productsCooked.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static boolean hasCookedEachMeal(Map<String, Integer> productsCooked) {
        /*return productsCooked.values()
                .stream()
                .noneMatch(c -> c == 0);*/

        for (int count : productsCooked.values()) {
            if (count == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean ableToCookProduct(int sum) {
        return  sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }
}
