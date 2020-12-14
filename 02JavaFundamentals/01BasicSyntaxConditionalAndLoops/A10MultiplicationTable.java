package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A10MultiplicationTable {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();

        for (int i = 1; i<= 10; i++){
            int result = num * i;
            System.out.printf("%d X %d = %d%n", num, i, result);
        }
    }
}
