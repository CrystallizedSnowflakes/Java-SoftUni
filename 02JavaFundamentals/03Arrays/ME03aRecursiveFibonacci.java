package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME03aRecursiveFibonacci {

    public static void main(String[] args) {
        // Recursive Fibonacci
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        // on n position lends ? Fibonacci number
        // on position 10 lends number 55
        // 1 2 3 4 5 6 7  8  9  10 position
        // 1 1 2 3 5 8 13 21 34 55 Fibonacci number
        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
