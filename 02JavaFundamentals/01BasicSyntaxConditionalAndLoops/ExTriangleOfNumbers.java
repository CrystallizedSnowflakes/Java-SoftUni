package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ExTriangleOfNumbers {
    public static void main(String[] args) {

        int end = new Scanner(System.in).nextInt();

        for (int i = 1; i <= end; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
// 1
// 1 2
// 1 2 3
