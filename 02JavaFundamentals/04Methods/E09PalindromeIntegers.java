package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        while (!input.equals("end")){
            System.out.println(isNumberPalindrome(input));
            input = scanner.nextLine().toLowerCase();
        }
    }

    private static boolean isNumberPalindrome(String input) {
        boolean isNumberPalindrome = false;
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        if (input.equals(reversed)){
            isNumberPalindrome = true;
        }
        return isNumberPalindrome;
    }
}
