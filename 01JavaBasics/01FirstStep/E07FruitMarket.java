package bg.softuni.javabasics;

import java.util.Scanner;

public class E07FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberryPricePerKg = Double.parseDouble(scanner.nextLine());
        double bananaKgs = Double.parseDouble(scanner.nextLine());
        double orangeKgs = Double.parseDouble(scanner.nextLine());
        double raspberryKgs = Double.parseDouble(scanner.nextLine());
        double strawberryKgs = Double.parseDouble(scanner.nextLine());

        double strawberrySum = strawberryKgs * strawberryPricePerKg;

        // raspberryPricePerKg = 50% less from strawberryPricePerKg = 50/100 = 0.5
        //double raspberryPricePerKg = strawberryPricePerKg - (0.5 * strawberryPricePerKg);
        double raspberryPricePerKg = strawberryPricePerKg / 2;
        double raspberrySum = raspberryKgs * raspberryPricePerKg;

        // orangePricePerKg = 40% less from raspberryPricePerKg = 40/100 = 0.4
        //double orangePricePerKg = raspberryPricePerKg - (0.4 * raspberryPricePerKg);
        double orangePricePerKg = 0.6 * raspberryPricePerKg;
        double orangeSum = orangeKgs * orangePricePerKg;

        // bananaPricePerKg = 80% less from raspberryPricePerKg = 80/100 = 0.8
        //double bananaPricePerKg = raspberryPricePerKg - (0.8 * raspberryPricePerKg);
        double bananaPricePerKg = 0.2 * raspberryPricePerKg;
        double bananaSum = bananaKgs * bananaPricePerKg;

        double price = strawberrySum + raspberrySum + orangeSum + bananaSum;
        System.out.printf("%.2f", price);
    }
}
