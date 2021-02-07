package bg.softuni.javaadvanced;

import java.util.*;

public class Ex01LootBox_22Feb2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\s+");
        String[] secondInput = scanner.nextLine().split("\\s+");

        List<Integer> claimedItems = new ArrayList<>();

        ArrayDeque<Integer> lootBoxQueue = new ArrayDeque<>();
        for (String item : firstInput) {
            lootBoxQueue.offer(Integer.parseInt(item));
        }

        ArrayDeque<Integer> lootBoxStack = new ArrayDeque<>();
        for (String item : secondInput) {
            lootBoxStack.push(Integer.parseInt(item));
        }

        while (!lootBoxQueue.isEmpty()){
            int itemFQ = lootBoxQueue.peek();
            if (!lootBoxStack.isEmpty()){
                int itemLS = lootBoxStack.peek();
                int sum = itemFQ + itemLS;
                if (sum % 2 == 0){
                    claimedItems.add(sum);
                    lootBoxQueue.poll();
                    lootBoxStack.pop();
                } else {
                    int onQueue = lootBoxStack.pop();
                    lootBoxQueue.offer(onQueue);
                }
            } else {
                break;
            }
        }

        if (lootBoxQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if (lootBoxStack.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        int sumOfClaimedItems = claimedItems.stream().mapToInt(Integer::valueOf).sum();
        if (sumOfClaimedItems >= 100){
            System.out.printf("Your loot was epic! Value: %d%n", sumOfClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", sumOfClaimedItems);
        }
    }
}
