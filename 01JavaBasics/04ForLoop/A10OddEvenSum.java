package bg.softuni.javabasics;

import java.util.Scanner;

public class A10OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int evenIndexSum = 0;
        int oddIndexSum = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0){
               evenIndexSum += number;
            }else{ //i % 2 != 0
                oddIndexSum += number;
            }
        }
        if (evenIndexSum == oddIndexSum){
            System.out.println("Yes");
            System.out.printf("Sum = %d", evenIndexSum);
        }else{
            int diff = Math.abs(evenIndexSum - oddIndexSum);
            System.out.println("No");
            System.out.printf("Diff = %d", diff);
        }
    }
}
