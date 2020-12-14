package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A10SpecialNumbers {
    public static void main(String[] args) {

        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n; i++) {

            int sumOfDigit = 0;
            int num = i;

            while(num > 0){
                sumOfDigit += num % 10;  // takes last digit 20 -> 0
                num = num / 10;          // kut last digit 0 and takes first digits 20 -> 2
            }

            switch (sumOfDigit) {
                case 5:
                case 7:
                case 11:
                    System.out.printf("%d -> True%n", i);
                    break;
                default:
                    System.out.printf("%d -> False%n", i);
                    break;
            }
        }
    }
}
