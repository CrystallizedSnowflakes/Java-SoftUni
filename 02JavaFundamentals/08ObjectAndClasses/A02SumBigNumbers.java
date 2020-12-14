package bg.softuni.javafundamentals;

import java.math.BigInteger;
import java.util.Scanner;

public class A02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //I.	Using the Built-in Java Classes

        BigInteger firstNumber = scanner.nextBigInteger();
        BigInteger secondNumber = scanner.nextBigInteger();

        BigInteger sum = firstNumber.add(secondNumber);

        System.out.println(sum);
    }
}
