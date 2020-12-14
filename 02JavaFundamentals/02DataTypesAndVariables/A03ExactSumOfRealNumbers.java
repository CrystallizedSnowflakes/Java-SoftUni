package bg.softuni.javafundamentals;

import java.math.BigDecimal;
import java.util.Scanner;

public class A03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        BigDecimal output = new BigDecimal(0); // starting value = 0
        for (int i = 0; i < n; i++) {
            BigDecimal input = scanner.nextBigDecimal();
            output = output.add(input);
        }
        System.out.println(output);
    }
}
