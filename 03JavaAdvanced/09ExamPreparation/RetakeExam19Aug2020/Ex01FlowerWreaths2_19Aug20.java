package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Ex01FlowerWreaths2_19Aug20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(liliesStack::push);

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(rosesQueue::offer);

        int wreaths = 0;
        int store = 0;

        while (!liliesStack.isEmpty()){
            int lastLily = liliesStack.pop();

            if (!rosesQueue.isEmpty()) {
                int firstRose = rosesQueue.poll();
                int sum = lastLily + firstRose;

                if (sum == 15) {
                    wreaths++;
                } else if (sum > 15) {
                    if (sum % 2 != 0) { // => end at 17 - 2 = 15
                        wreaths++;
                    } else {
                        store += 14; // sum % 2 == 0 => end at 16 - 2 = 14
                    }
                } else {
                    store += sum;
                }
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
