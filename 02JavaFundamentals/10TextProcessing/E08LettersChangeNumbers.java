package bg.softuni.javafundamentals;

import java.util.Scanner;

public class    E08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double sum = 0.0;

        for (String token : tokens) {
            char firstLetter = token.charAt(0);
            char lastLetter = token.charAt(token.length() - 1);
            double number = Double.parseDouble(token.substring(1, token.length() - 1 ));

            int firstLetterPosition = getLetterAlphabeticPosition(firstLetter);
            int lastLetterPosition = getLetterAlphabeticPosition(lastLetter);

            if (Character.isUpperCase(firstLetter)){
                sum += number / firstLetterPosition;
            } else { // lowerCase
                sum += number * firstLetterPosition;
            }

            if (Character.isUpperCase(lastLetter)){
                sum -= lastLetterPosition;
            } else {
                sum += lastLetterPosition;
            }
        }
        System.out.printf("%.2f", sum);
    }

    private static int getLetterAlphabeticPosition(char c){
        char targetChar = Character.toLowerCase(c);
        char initialChar = 'a';
        int position = targetChar - initialChar + 1;

        return position;
    }
}
