package bg.softuni.basics;

import java.util.Scanner;

public class A03SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        int sum = 0;
        while (sum < number){
            int currentNumber = scanner.nextInt();
            sum += currentNumber;
        }
        System.out.println(sum);
    }
}
