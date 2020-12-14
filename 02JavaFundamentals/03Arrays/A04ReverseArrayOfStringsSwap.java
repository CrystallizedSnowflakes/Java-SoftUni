package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A04ReverseArrayOfStringsSwap {
    public static void main(String[] args) {

        String[] arrStrings = new Scanner(System.in).nextLine().split(" ");

        for (int i = 0; i < arrStrings.length / 2; i++) {
            int swapIndex = arrStrings.length - 1 - i;
            String oldNumbersI = arrStrings[i];
            arrStrings[i] = arrStrings[swapIndex];
            arrStrings[swapIndex] = oldNumbersI;
        }
        System.out.println(String.join(" ", arrStrings));
    }
}
