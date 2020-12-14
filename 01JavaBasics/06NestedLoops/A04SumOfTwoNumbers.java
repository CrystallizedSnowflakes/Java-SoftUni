package bg.softuni.javabasics;

import java.util.Scanner;

public class A04SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int i = start; i <= end ; i++) {
            for (int j = start; j <= end; j++) {
                count++;
                int product = i + j;
                if (product == magicNumber){
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, i, j , product);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", count, magicNumber);
    }
}
