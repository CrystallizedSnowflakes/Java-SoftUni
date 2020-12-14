package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME04TribonacciSequence {
    public static void main(String[] args) {
        // Recursive Tribonacci
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++)
        {
            System.out.printf("%d ",getTribonacci(i));
        }
    }

    private static long getTribonacci(int num) {

        if (num <= 2)
        {
            return 1;
        }

        if (num == 3)
        {
            return 2;
        }
        else
        {
            return getTribonacci(num - 3) +
                    getTribonacci(num - 2) +
                    getTribonacci(num - 1);
        }
    }
}
