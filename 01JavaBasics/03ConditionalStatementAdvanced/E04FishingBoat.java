package bg.softuni.javabasics;

import java.util.Scanner;

public class E04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishMen = Integer.parseInt(scanner.nextLine());

        double rent = 0.0;

        switch (season){
            case "Spring":
                rent = 3000;
                break;
            case "Summer":
            case "Autumn":
                rent = 4200;
                break;
            case "Winter":
                rent = 2600;
                break;
        }

        if (fishMen <= 6){
            rent *= 0.9;
        }else if(fishMen <= 11){
            rent *= 0.85;
        }else{
            rent *= 0.75;
        }

        if (fishMen % 2 == 0 && !season.equals("Autumn")){
            rent *= 0.95;
        }

        if (budget >= rent){
            double leftMoney = budget - rent;
            System.out.printf("Yes! You have %.2f leva left.", leftMoney);
        }else{
            double neededMoney = rent - budget;
            System.out.printf("Not enough money! You need %.2f leva.", neededMoney);
        }
    }
}
