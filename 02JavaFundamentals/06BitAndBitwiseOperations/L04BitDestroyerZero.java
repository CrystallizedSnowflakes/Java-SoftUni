package bg.softuni.javafundamentals;

import java.util.Scanner;

public class L04BitDestroyerZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // sets (clear) the bit at position p to 0

        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        int mask = ~(1 << p); // zeroes // formula

        int newNumber = n & mask;

        System.out.println(newNumber);
    }
}
