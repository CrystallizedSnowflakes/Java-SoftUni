package bg.softuni.javabasics;

import java.util.Scanner;

public class E06GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double pricePerStatist = Double.parseDouble(scanner.nextLine());

        // 10% from Budget
        double priceDecor = budget * 0.10;
        double priceStatists = statists * pricePerStatist;

        if (statists > 150){
            // less with 10%  from pricePerStatist
            priceStatists = 0.90 * priceStatists;
        }
        double expenses = priceDecor + priceStatists;

        if (budget >= expenses){
            System.out.println("Action!");
            double leftMoney = budget - expenses;
            System.out.printf("Wingard starts filming with %.2f leva left.", leftMoney);
        }else{
            System.out.println("Not enough money!");
            double needMoney = expenses - budget;
            System.out.printf("Wingard needs %.2f leva more.", needMoney);
        }
    }
}
