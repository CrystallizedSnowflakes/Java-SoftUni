package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A02PoundsToDollars {
    public static void main(String[] args) {

        double britishPounds = new Scanner(System.in).nextDouble();

        double convertedBritishPounds = britishPounds * 1.31;

        System.out.printf("%.3f", convertedBritishPounds);
    }
}
