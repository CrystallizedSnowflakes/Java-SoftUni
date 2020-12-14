package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E02SumDigits {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result += input.charAt(i) - 48;
        }
        System.out.println(result);
    }
}
