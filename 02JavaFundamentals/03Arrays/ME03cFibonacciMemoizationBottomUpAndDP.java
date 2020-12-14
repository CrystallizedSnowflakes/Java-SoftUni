package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME03cFibonacciMemoizationBottomUpAndDP {
    public static void main(String[] args) {
        // DP Dynamic Programming and Memoization Bottom-Up
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci(n));

    }

    public static long fibonacci(int n) {
        long[] fib = new long[n + 2];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
