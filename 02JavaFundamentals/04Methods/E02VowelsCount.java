package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E02VowelsCount {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine().toLowerCase();

        printCountOfVowels(input);
    }

    private static void printCountOfVowels(String inputString) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == 'a' || inputString.charAt(i) == 'e'
            || inputString.charAt(i) == 'i' || inputString.charAt(i) == 'o'
            || inputString.charAt(i) == 'u'){
                count++;
            }
        }
        System.out.println(count);
    }
}
