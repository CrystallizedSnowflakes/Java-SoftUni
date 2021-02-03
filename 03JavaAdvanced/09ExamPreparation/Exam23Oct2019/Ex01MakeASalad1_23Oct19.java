package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex01MakeASalad1_23Oct19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vegetables = scanner.nextLine().split("\\s+");
        String[] calories = scanner.nextLine().split("\\s+");

        ArrayDeque<String> vegetablesQueue = new ArrayDeque<>();
        for (String vegetable : vegetables) {
            vegetablesQueue.offer(vegetable);
        }

        ArrayDeque<Integer> caloriesStack = new ArrayDeque<>();
        for (String calorie : calories) {
            caloriesStack.push(Integer.parseInt(calorie));
        }

        while (!caloriesStack.isEmpty() && !vegetablesQueue.isEmpty()) {
            int salad = caloriesStack.peek();

            while (salad > 0 && !vegetablesQueue.isEmpty()){
                String vegetable = vegetablesQueue.poll();

                switch(vegetable){
                    case "tomato":
                        salad -= 80;
                        break;
                    case "carrot":
                        salad -= 136;
                        break;
                    case "lettuce":
                        salad -= 109;
                        break;
                    case "potato":
                        salad -= 215;
                        break;
                    default:
                        break;
                }
            }
            System.out.print(caloriesStack.pop() + " ");
        }
        System.out.println();

        while (!caloriesStack.isEmpty()){
            System.out.print(caloriesStack.pop() + " ");
        }

        while (!vegetablesQueue.isEmpty()){
            System.out.print(vegetablesQueue.poll() + " ");
        }
    }
}
