package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E04SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        int totalSum = 0;
        for (int i = 0; i < numberOfInputs; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                totalSum += input.charAt(j);
            }
        }
        System.out.printf("The sum equals: %d", totalSum);
    }
}
