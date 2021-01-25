package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex01FlowerWreaths1_19Aug20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lilies = scanner.nextLine().split(", ");
        String[] roses = scanner.nextLine().split(", ");

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        for (String lily : lilies) {
            liliesStack.push(Integer.parseInt(lily));
        }

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        for (String rose : roses) {
            rosesQueue.offer(Integer.parseInt(rose));
        }


        int wreaths = 0;
        int store = 0;

        while (!liliesStack.isEmpty()){
            int lastLilly = liliesStack.pop();

            if (!rosesQueue.isEmpty()) {
                int firstRose = rosesQueue.poll();
                int sum = lastLilly + firstRose;

                if (sum == 15) {
                    wreaths++;
                } else if (sum > 15) {
                    while (sum > 15) {
                        lastLilly -= 2;
                        sum = lastLilly + firstRose;
                    }
                    if (sum == 15) {
                        wreaths++;
                    } else {
                        store += sum;
                    }
                } else {
                    store += sum;
                }
            }
        }

        while (store >= 15){
            store -= 15;
            wreaths++;
        }

        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            int neededWreaths = 5 - wreaths;
            System.out.printf("You didn't make it, you need %d wreaths more!%n", neededWreaths);
        }
    }
}
