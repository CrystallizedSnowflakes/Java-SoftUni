package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A01ConvertMetersToKilometers {
    public static void main(String[] args) {

        int meters = new Scanner(System.in).nextInt();
        double km = meters * 0.001;

        System.out.printf("%.2f", km);
    }
}
