package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME03bFibonacciMemoizationTopDownAndDP {
    // DP Dynamic Programming and Memoization Top-Down
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci(n));

    }

    public static long fibonacci(int n){
        long[]memo = new long[n+2];

        if (memo[n] != 0) return memo[n];
        if (n==0) return 0;
        if (n==1) return 1;
        memo[n] = fibonacci(n-1) + fibonacci(n-2);
        return memo[n];
    }
}
