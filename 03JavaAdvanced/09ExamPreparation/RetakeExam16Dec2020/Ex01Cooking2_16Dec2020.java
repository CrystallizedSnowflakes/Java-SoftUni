package bg.softuni.javaadvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Ex01Cooking2_16Dec2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("Bread", 0);
        materials.put("Cake", 0);
        materials.put("Pastry", 0);
        materials.put("Fruit Pie", 0);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsStack::push);

        boolean fourIngredientsAreCollected = false;
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;
            switch (sum){
                case 25:
                    materials.put("Bread", materials.get("Bread") + 1);
                    break;
                case 50:
                    materials.put("Cake", materials.get("Cake") + 1);
                    break;
                case 75:
                    materials.put("Pastry", materials.get("Pastry") + 1);
                    break;
                case 100:
                    materials.put("Fruit Pie", materials.get("Fruit Pie") + 1);
                    break;
                default:
                    int increasedIngredient = ingredient + 3;
                    ingredientsStack.push(increasedIngredient);
                    break;
            }

            if (materials.get("Bread") >= 1 && materials.get("Cake") >= 1
                    && materials.get("Pastry") >= 1 && materials.get("Fruit Pie") >= 1){
                fourIngredientsAreCollected = true;
            }
        }

        if (fourIngredientsAreCollected){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        if (liquidsQueue.isEmpty()){
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s%n",
                    liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s%n",
                    ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        materials.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
