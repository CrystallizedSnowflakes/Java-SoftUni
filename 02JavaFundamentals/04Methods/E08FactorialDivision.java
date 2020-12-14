package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        double result = calculateFactorialN(a) /(double) calculateFactorialN(b);
        //double division = divideFirstBySecondFactorial(a,b);
        System.out.printf("%.2f", result);
    }

//    private static double divideFirstBySecondFactorial(int a, int b) {
//        return calculateFactorialN(a) /(double) calculateFactorialN(b);
//    }

    private static long calculateFactorialN(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;

//        if (n == 0)
//            return 1;
//        else
//            return (n * calculateFactorialN(n - 1));
    }
}
