package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        int result = getMultipleOfEvensAndOdds(num);
        System.out.println(result);
    }

    //II.	Returning Values and Overloading
    private static int getMultipleOfEvensAndOdds(int number) {
        int evensSum = getSumOfEvenDigit(number);
        int oddsSum = getSumOfOddDigit(number);

        return evensSum * oddsSum;
    }


    private static int getSumOfEvenDigit(int number) {
        int evensSum = 0;
        //while(Math.abs(n) != 0){
        while(number != 0){
            int lastDigit = number % 10;
            number = number / 10;
            if (lastDigit % 2 == 0){
                evensSum += lastDigit;
            }
        }
        return evensSum;
    }

    private static int getSumOfOddDigit(int number) {
        int oddsSum = 0;
        //while(Math.abs(n) != 0){
        while(number != 0){
            int lastDigit = number % 10;
            number = number / 10;
            if (lastDigit % 2 != 0){
                oddsSum += lastDigit;
            }
        }
        return oddsSum;
    }
}
