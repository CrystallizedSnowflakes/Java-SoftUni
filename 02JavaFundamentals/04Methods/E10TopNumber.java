package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        findAllTopIntegers(number);
    }

    private static void findAllTopIntegers(int number){
        for (int i = 1; i <= number ; i++) {
            if (isSumOfDigitsIsDivisibleBy8(i) && holdsAtLeastOneOddDigit(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean isSumOfDigitsIsDivisibleBy8(int number){
        boolean isSumOfDigitsIsDivisibleBy8 = false;
        int sum = 0;
        while (number != 0){
            int lastDigit = number % 10;
            number = number / 10;
            sum += lastDigit;
        }
        if (sum % 8 == 0){
            isSumOfDigitsIsDivisibleBy8 = true;
        }
        return isSumOfDigitsIsDivisibleBy8;
    }

    private static boolean holdsAtLeastOneOddDigit(int number){
        boolean holdsAtLeastOneOddDigit = false;
        while (number != 0){
            int lastDigit = number % 10;
            number = number / 10;
            if (lastDigit % 2 != 0){
                holdsAtLeastOneOddDigit = true;
                break;
            }
        }
        return holdsAtLeastOneOddDigit;
    }
}
