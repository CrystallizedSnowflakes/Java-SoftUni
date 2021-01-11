package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E10PoisonousPlantsMemoization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        // on which day the plant dies !!!
        int[] daysOfDeath = new int[n]; // memory
        ArrayDeque<Integer> prevPlants = new ArrayDeque<>();

        // we put the first plant into ArrayDeque as index
        prevPlants.push(0);

        // there is no smallest plant in front of first one so first can't die => loop starts from second plant = 1
        for (int i = 1; i < plants.length; i++) {
            int currentDay = 0;
            // while firstPlant >= SecondPlant -> will be alive or will dies
            while (!prevPlants.isEmpty() && plants[prevPlants.peek()] >= plants[i]){
                // one day passed
                int value = prevPlants.pop();
                currentDay = Math.max(currentDay, daysOfDeath[value]);
            }
            if (!prevPlants.isEmpty()){ // the plant is alive for another day
                daysOfDeath[i] = currentDay + 1;
            }
            // move to next plant
            prevPlants.push(i);
        }

        System.out.println(Arrays.stream(daysOfDeath).max().getAsInt());
    }
}
