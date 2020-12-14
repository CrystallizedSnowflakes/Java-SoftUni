package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A01ReverseStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        while (!"end".equals(word)){
            String reversedWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord += word.charAt(i);
            }
            System.out.println(word + " = " + reversedWord);
            word = scanner.nextLine();
        }
    }
}
