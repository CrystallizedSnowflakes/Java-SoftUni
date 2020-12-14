package bg.softuni.javabasics;

import java.util.Scanner;

public class E05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String vacation = "";
        String destination = "";
        double spentMoney = 0.0;

        switch (season){
            case "summer":
                vacation = "Camp";
                if (budget <= 100){
                    destination = "Bulgaria";
                    spentMoney = budget * 0.30;
                }else if(budget <= 1000){
                    destination = "Balkans";
                    spentMoney = budget * 0.40;
                }
                break;
            case "winter":
                vacation = "Hotel";
                if (budget <= 100){
                    destination = "Bulgaria";
                    spentMoney = budget * 0.70;
                }else if(budget <= 1000){
                    destination = "Balkans";
                    spentMoney = budget * 0.80;
                }
                break;

        }

        if(budget > 1000) {
            destination = "Europe";
            vacation = "Hotel";
            spentMoney = budget * 0.90;
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", vacation, spentMoney);
    }
}
