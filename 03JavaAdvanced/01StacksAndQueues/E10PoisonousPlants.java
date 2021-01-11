package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E10PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split(" ");

        int[] plants = new int[n];
        for (int i = 0; i < n; i++) {
            plants[i] = Integer.parseInt(tokens[i]);
        }

        Deque<Integer> indicesStack = new ArrayDeque<>();
        indicesStack.push(0);
        int[] days = new int[n];
        for (int i = 1; i < n; i++) {
            int maxDays = 0;
            while (!indicesStack.isEmpty() && plants[indicesStack.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[indicesStack.pop()]);
            }
            if (!indicesStack.isEmpty()) {
                days[i] = maxDays + 1;
            }
            indicesStack.push(i);
        }
        System.out.println(getLastDay(days));
    }

    private static int getLastDay(int[] days) {
        int lastDay = 0;
        for (int day : days) {
            if (day > lastDay) {
                lastDay = day;
            }
        }
        return lastDay;
    }
}
