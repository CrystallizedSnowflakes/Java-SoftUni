package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class A04AddVatUnaryOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatAdder = priceWithoutVat -> priceWithoutVat * 1.20;

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(e -> vatAdder.apply(Double.parseDouble(e)))
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
