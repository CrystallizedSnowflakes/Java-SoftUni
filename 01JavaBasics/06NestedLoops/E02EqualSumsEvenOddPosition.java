package bg.softuni.javabasics;

import java.util.Scanner;

public class E02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int number = start; number <= end; number++) {
            // 534823
            int units = number % 10;
            int tens = number / 10 % 10;
            int hundreds = number / 100 % 10;
            int thousands = number / 1000 % 10;
            int tenThousand = number / 10000 % 10;
            int hundredThousand = number / 100000;
            // 3 + 8 + 3
            int sumEvenPositions = units + hundreds + tenThousand;
            // 5 + 4 + 2
            int sumOddPosition = tens + thousands + hundredThousand;

            if(sumEvenPositions == sumOddPosition){
                System.out.print(number + " ");
            }
        }
    }
}
