package bg.softuni.javafundamentals;

import java.math.BigInteger;
import java.util.Scanner;

public class A03BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //I.	Using the Built-in Java Classes

        int n = Integer.parseInt(scanner.nextLine());

        BigInteger factorial = new BigInteger(String.valueOf(1));

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(Integer.parseInt(String.valueOf(i))));
        }

        System.out.println(factorial);
    }
}
