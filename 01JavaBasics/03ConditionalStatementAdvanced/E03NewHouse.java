package bg.softuni.javabasics;

import java.util.Scanner;

public class E03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flower = scanner.nextLine();
        int quality = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0.0;

        switch (flower){
            case "Roses":
                price = 5.00 * quality;
                if (quality > 80){
                    price *= 0.90;
                }
                break;
            case "Dahlias":
                price = 3.80 * quality;
                if (quality > 90){
                    price *= 0.85;
                }
                break;
            case "Tulips":
                price = 2.80 * quality;
                if (quality > 80){
                    price *= 0.85;
                }
                break;
            case "Narcissus":
                price = 3.00 * quality;
                if (quality < 120){
                    // price = price + 15% from price
                    price = 1.15 * price;
                }
                break;
            case "Gladiolus":
                price = 2.50 * quality;
                if (quality < 80){
                    // price = price + 20% from price
                    price += 0.20 * price;
                }
                break;
        }
        if (budget >= price){
            double moneyLeft = budget - price;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", quality, flower, moneyLeft);
        }else{
            double neededMoney = price - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", neededMoney);
        }
    }
}
