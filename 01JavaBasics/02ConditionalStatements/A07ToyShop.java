package bg.softuni.javabasics;

import java.util.Scanner;

public class A07ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double excursionCosts = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int speakingDolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double puzzlesIncomes = puzzles * 2.60;
        double speakingDollsIncomes = speakingDolls * 3.00;
        double teddyBearsIncomes = teddyBears * 4.10;
        double minionsIncomes = minions * 8.20;
        double trucksIncomes = trucks * 2.00;

        double incomes = puzzlesIncomes + speakingDollsIncomes + teddyBearsIncomes + minionsIncomes + trucksIncomes;

        int toys = puzzles + speakingDolls + teddyBears + minions + trucks;
        if (toys >= 50){
            incomes *= 0.75;
        }
        incomes *= 0.90;
        if (incomes >= excursionCosts){
            double balance = incomes - excursionCosts;
            System.out.printf("Yes! %.2f lv left.", balance);
        }else{
            double moneyNeeded = excursionCosts - incomes;
            System.out.printf("Not enough money! %.2f lv needed.", moneyNeeded);
        }
    }
}
