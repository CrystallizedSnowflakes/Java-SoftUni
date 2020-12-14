package bg.softuni.javabasics;

import java.util.Scanner;

public class A11FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String weekDay = scanner.nextLine();
        double quality = Double.parseDouble(scanner.nextLine());

        double price = 0.0;

        switch (weekDay){
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                switch(fruit){
                    case "banana":
                        price = 2.50 * quality;
                        break;
                    case "apple":
                        price = 1.20 * quality;
                        break;
                    case "orange":
                        price = 0.85 * quality;
                        break;
                    case  "grapefruit":
                        price = 1.45 * quality;
                        break;
                    case "kiwi":
                        price = 2.70 * quality;
                        break;
                    case "pineapple":
                        price = 5.50 * quality;
                        break;
                    case "grapes":
                        price = 3.85 * quality;
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                break;
            case "Saturday":
            case "Sunday":
                switch(fruit){
                    case "banana":
                        price = 2.70 * quality;
                        break;
                    case "apple":
                        price = 1.25 * quality;
                        break;
                    case "orange":
                        price = 0.90 * quality;
                        break;
                    case  "grapefruit":
                        price = 1.60 * quality;
                        break;
                    case "kiwi":
                        price = 3.00 * quality;
                        break;
                    case "pineapple":
                        price = 5.60 * quality;
                        break;
                    case "grapes":
                        price = 4.20 * quality;
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                break;
            default:
                System.out.println("error");
                break;
        }
        if (price != 0){
            System.out.printf("%.2f", price);
        }
    }
}
