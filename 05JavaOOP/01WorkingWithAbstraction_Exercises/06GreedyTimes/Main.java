
package e06greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i];
            long quantity = Long.parseLong(input[i + 1]);

            if (item.length() == 3) {
                // add "Cash" to bag;
                bag.addCash(item, quantity);
            } else if (item.toLowerCase().endsWith("gem")) {
                // add "Gem" to bag;
                bag.addGem(item, quantity);
            } else if (item.equalsIgnoreCase("gold")) {
                // add "Gold" to bag;
                bag.addGold(quantity);
            }
        }
        System.out.println(bag.toString());
    }
}