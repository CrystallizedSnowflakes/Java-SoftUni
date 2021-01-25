package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex01FlowerWreaths3_19Aug20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int wreaths = 0;
        int store = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lastLilly = liliesStack.peek();
            int firstRose = rosesQueue.peek();
            int sum = lastLilly + firstRose;

            if (sum == 15) {
                wreaths++;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (sum > 15) {
                liliesStack.pop();
                lastLilly -= 2;
                liliesStack.push(lastLilly);
            } else {
                store += sum;
                liliesStack.pop();
                rosesQueue.poll();
            }
        }

        wreaths += store / 15;

        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            int neededWreaths = 5 - wreaths;
            System.out.printf("You didn't make it, you need %d wreaths more!%n", neededWreaths);
        }
    }
}
