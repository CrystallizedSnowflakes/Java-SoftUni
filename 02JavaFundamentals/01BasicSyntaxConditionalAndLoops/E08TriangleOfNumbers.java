package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E08TriangleOfNumbers {
    public static void main(String[] args) {
        int end = new Scanner(System.in).nextInt();

        for (int i = 1; i <= end; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// 1
// 2 2
// 3 3 3
