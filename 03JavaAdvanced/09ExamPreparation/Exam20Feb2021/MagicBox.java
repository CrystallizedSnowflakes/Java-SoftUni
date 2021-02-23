package bg.softuni.javaadvanced;

import java.util.*;
import java.util.stream.Collectors;

public class a01_MagicBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Queue
        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // add()

        // Stack
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int totalSum = 0;
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int firstBoxItem = firstBoxQueue.peek();
            int secondBoxItem = secondBoxStack.pop();
            int sum = firstBoxItem + secondBoxItem;

            if (sum % 2 == 0){
                firstBoxQueue.poll();
                totalSum += sum;
            } else {
                firstBoxQueue.offer(secondBoxItem);
            }
        }

        if (firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }

        if (secondBoxStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if (totalSum >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d%n", totalSum);
        } else {
            System.out.printf("Poor prey... Value: %d%n", totalSum);
        }
    }
}
