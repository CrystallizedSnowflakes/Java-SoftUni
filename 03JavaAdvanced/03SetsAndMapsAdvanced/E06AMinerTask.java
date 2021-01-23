package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class E06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> dataQueue = new ArrayDeque<>();
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("stop")){
            dataQueue.offer(input);
            if (dataQueue.size() == 2){
                String nameOfResource = dataQueue.poll();
                int quantity = Integer.parseInt(dataQueue.poll());

                resources.putIfAbsent(nameOfResource, 0);
                int currentQuantity = resources.get(nameOfResource);
                resources.put(nameOfResource, quantity + currentQuantity);
            }

            input = scanner.nextLine();
        }
        resources.forEach((k, v) -> {
            System.out.printf("%s -> %s%n", k, v);
        });
    }
}
