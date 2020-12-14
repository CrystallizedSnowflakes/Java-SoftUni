package bg.softuni.javabasics;

import java.util.Scanner;

public class E06SpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        // 1111 to 9999
        for (int number = 1111; number <= 9999 ; number++) {
            // print special numbers
            int ones = number % 10;              // 2148 % 10 = 8
            int tens = number / 10 % 10;         // 2148 / 10 = 214 % 10 = 4
            int hundreds = number / 100 % 10;     // 2148 / 100 = 21 % 10 = 1
            int thousands = number / 1000 % 10;   // 2148 / 1000 = 2

            boolean checkOnes = ones != 0 && n % ones == 0;
            boolean checkTens = tens != 0 && n % tens == 0;
            boolean checkHundreds =  hundreds != 0 && n % hundreds == 0;
            boolean checkThousands =  n % thousands == 0;

            if (checkOnes && checkTens && checkHundreds && checkThousands){
                System.out.print(number + " ");
            }
        }
    }
}
