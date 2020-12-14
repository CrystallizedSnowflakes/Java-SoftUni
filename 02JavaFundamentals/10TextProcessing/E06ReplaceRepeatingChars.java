package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        char previousChar = input.charAt(0);
        sb.append(previousChar); // put first symbol from input to sb

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (previousChar != currentChar){
                sb.append(currentChar);
                previousChar = currentChar;
            }
        }
        System.out.println(sb.toString());
    }
}
