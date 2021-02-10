package bg.softuni.javaadvanced;

import java.util.*;

public class Ex01Bombs_28June2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        int[] bombEffects = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] bombCasing = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queueBombEffects = new ArrayDeque<>();
        for (int bombEffect : bombEffects) {
            queueBombEffects.offer(bombEffect);
        }

        ArrayDeque<Integer> stackBombCasing = new ArrayDeque<>();
        for (int bombC : bombCasing) {
            stackBombCasing.push(bombC);
        }

        boolean bombPouchIsFull = false;
        while (!queueBombEffects.isEmpty() && !stackBombCasing.isEmpty()){
            int sum = queueBombEffects.peek() + stackBombCasing.peek();
            switch (sum){
                case 40:
                    bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                    queueBombEffects.poll();
                    stackBombCasing.pop();
                    break;
                case 60:
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                    queueBombEffects.poll();
                    stackBombCasing.pop();
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                    queueBombEffects.poll();
                    stackBombCasing.pop();
                    break;
                default:
                    int decreasedBombC = stackBombCasing.pop() - 5;
                    stackBombCasing.push(decreasedBombC);
                    break;
            }

            if (bombs.get("Datura Bombs") >= 3
                    && bombs.get("Cherry Bombs") >= 3
                    && bombs.get("Smoke Decoy Bombs") >= 3){
                bombPouchIsFull = true;
                break;
            }
        }

        if (bombPouchIsFull){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        StringBuilder sbEffects = new StringBuilder("Bomb Effects: ");
        if (!queueBombEffects.isEmpty()){
            while (queueBombEffects.size() > 1){
                sbEffects.append(queueBombEffects.poll()).append(", ");
            }
            sbEffects.append(queueBombEffects.poll());
            System.out.println(sbEffects.toString());
        } else {

            System.out.println("Bomb Effects: empty");
        }

        StringBuilder sbCasting = new StringBuilder("Bomb Casings: ");
        if (!stackBombCasing.isEmpty()){
            while (stackBombCasing.size() > 1){
                sbCasting.append(stackBombCasing.pop()).append(", ");
            }
            sbCasting.append(stackBombCasing.pop());
            System.out.println(sbCasting.toString());

        } else {
            System.out.println("Bomb Casings: empty");
        }

        bombs.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}
