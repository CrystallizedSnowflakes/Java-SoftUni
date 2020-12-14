package bg.softuni.javafundamentals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Character, Integer> letterOccurrences = new LinkedHashMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' '){
                Character letters = input.charAt(i);
                Integer occurrences = letterOccurrences.get(letters);
                if (occurrences == null){
                    occurrences = 0;
                }
                letterOccurrences.put(letters, occurrences + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : letterOccurrences.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
