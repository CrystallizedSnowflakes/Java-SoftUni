package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();
        String thirdInput = scanner.nextLine();

        char firstChar = firstInput.charAt(0);
        char secondChar = secondInput.charAt(0);
        char thirdChar = thirdInput.charAt(0);

        System.out.printf("%s%s%s", firstChar, secondChar, thirdChar);
    }
}
