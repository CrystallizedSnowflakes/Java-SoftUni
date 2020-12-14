package bg.softuni.javabasics;

import java.util.Scanner;

public class E03SumPrimeNonPrime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int primeSum = 0;
        int compositeSum = 0;

        while (!"stop".equals(command)){
            // просто или съставно
            // composite number has more than 2 dividers
            // prime number has 2 dividers (делителя - 1 и себе си) starts from 2
            int number = Integer.parseInt(command);
            if (number < 0){
                System.out.println("Number is negative.");
                command = scanner.nextLine();
                continue;
            }
            int dividers = 0;

            for (int i = 1; i <= number ; i++) {
                // from 1 to my number
                if (number % i == 0){
                    dividers++;
                }
            }

            if (dividers == 2){
                primeSum += number;
            }else if (dividers > 2){
                compositeSum += number;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", compositeSum);
    }
}
