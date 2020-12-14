package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A12RefactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumOfDigit = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0) {
                sumOfDigit += num % 10;
                num = num / 10;
            }

            if((sumOfDigit == 5)|| (sumOfDigit == 7) || (sumOfDigit == 11)){
                System.out.printf("%d -> True%n", i);
            }else{
                System.out.printf("%d -> False%n", i);
            }
            sumOfDigit = 0;
        }
    }
}
