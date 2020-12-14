package bg.softuni.javafundamentals;

import java.util.Scanner;

public class L04SetBitB0or1AtPosition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Assign a bit b (0 or 1) at position p

        int n = Integer.parseInt(scanner.nextLine()); // number 125
        int p = Integer.parseInt(scanner.nextLine()); //position 5
        int b = Integer.parseInt(scanner.nextLine()); // 1 or 0

        // Operator "~" (NOT = !) "tilda" | turns 1 to 0 and 0 to 1 :)
        int mask = ~(1 << p) | (b << p); // formula
                // delete bit
        int newNumber = n & mask;

        System.out.println(newNumber);
        // b = 1 -> 125
        // b = 0 -> 93
    }
}
