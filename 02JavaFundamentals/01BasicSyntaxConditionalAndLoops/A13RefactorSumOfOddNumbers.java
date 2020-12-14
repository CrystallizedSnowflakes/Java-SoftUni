package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A13RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int oddNum = (2 * i - 1);
            System.out.println(oddNum);
            sum += oddNum;
        }
        System.out.printf("Sum: %d%n", sum);
    }
}
