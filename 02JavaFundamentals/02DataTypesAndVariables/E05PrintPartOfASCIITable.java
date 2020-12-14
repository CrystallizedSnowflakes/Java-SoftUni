package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        for (int i = start; i < end ; i++) {
            System.out.print((char)i + " ");
        }
        System.out.print((char)end);
    }
}
