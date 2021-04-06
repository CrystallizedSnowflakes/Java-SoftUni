package a01RhombusOfStars;

import java.util.Scanner;

public class A01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int r = 1; r <= n; r++) {

            for (int s = 0; s < n - r; s++) {
                System.out.print(" ");
            }
            for (int s = 0; s < r; s++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int r = 1; r <= n - 1; r++) { // one row less
            for (int s = 0; s < r; s++) {
                System.out.print(" ");
            }
            for (int s = 0; s < n - r; s++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
