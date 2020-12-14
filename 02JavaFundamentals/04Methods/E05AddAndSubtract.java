package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int sum = getSum(a, b);
        int result = subtract(sum, c);
        System.out.println(result);
    }

    private static int getSum(int a, int b) {
        return a + b;
    }

    private static int subtract(int sum, int c) {
        return sum - c;
    }
}
