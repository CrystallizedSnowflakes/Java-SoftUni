package bg.softuni.javabasics;

import java.util.Scanner;

public class A09YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double squareMeters = Double.parseDouble(scanner.nextLine());
        double price = squareMeters * 7.61;
        double discount = 0.18 * price;
        double finalPrice = price - discount;

        System.out.printf("The final price is: %.2f lv.%n", finalPrice);
        System.out.printf("The discount is: %.2f lv.", discount);
    }
}
