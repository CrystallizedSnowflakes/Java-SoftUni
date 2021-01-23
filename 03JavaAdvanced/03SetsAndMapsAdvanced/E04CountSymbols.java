package bg.softuni.javaadvanced;

import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> occurrences = new TreeMap<>();
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            /*Integer currentNumber = occurrences.get(symbol);

            if (currentNumber == null){
                currentNumber = 0;
            }
            occurrences.put(symbol, currentNumber + 1);*/

            occurrences.putIfAbsent(symbol, 0);
            occurrences.put(symbol, occurrences.get(symbol) + 1);
        }

        occurrences.forEach((key, value) -> {
            System.out.printf("%c: %d time/s%n", key, value);
        });
    }
}
