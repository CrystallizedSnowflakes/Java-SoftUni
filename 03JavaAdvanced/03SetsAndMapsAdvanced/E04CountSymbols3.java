package bg.softuni.javaadvanced;

import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> symbols = new TreeMap<>();
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);

            int currentValue = symbols.getOrDefault(currentSymbol, 0);
            symbols.put(currentSymbol, currentValue + 1);
        }

        symbols.forEach((key, value) -> {
            System.out.printf("%c: %d time/s%n", key, value);
        });
    }
}
