package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME04ReverseString {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();
        String reverseInput = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reverseInput += input.charAt(i);
        }
        System.out.print(reverseInput);
    }
}
