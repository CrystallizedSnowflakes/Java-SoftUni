package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A03PrintingTriangle {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i < n; i++) {
            printLine(1, i);
        }
        printLine(1, n);
        for (int i = n - 1; i >= 1 ; i--) {
            printLine(1, i);
        }
    }

    //I.	Declaring and Invoking Methods (void = print)
    private static void printLine(int start, int end){
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
