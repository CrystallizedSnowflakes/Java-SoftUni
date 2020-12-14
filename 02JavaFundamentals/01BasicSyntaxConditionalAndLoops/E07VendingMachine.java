package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        double totalMoney = 0.0;
        while(!input.equals("start")){
            double currentCoins = Double.parseDouble(input);
            if(currentCoins == 0.1 || currentCoins == 0.2
            || currentCoins == 0.5 || currentCoins == 1
            || currentCoins == 2){
                totalMoney += currentCoins;
            }else{
                System.out.println(String.format("Cannot accept %.2f", currentCoins));
            }
          input = scanner.nextLine().toLowerCase();
        }

        input = scanner.nextLine().toLowerCase();
        while(!input.equals("end")){
            String marker = "";
            switch (input){
                case "nuts":
                    if (totalMoney >= 2){
                        totalMoney -= 2;
                        System.out.println("Purchased Nuts");
                    }else{
                        marker = "Sorry, not enough money";
                    }
                    break;
                case "water":
                    if (totalMoney >= 0.7){
                        totalMoney -= 0.7;
                        System.out.println("Purchased Water");
                    }else{
                        marker = "Sorry, not enough money";
                    }
                    break;
                case "crisps":
                    if (totalMoney >= 1.5){
                        totalMoney -= 1.5;
                        System.out.println("Purchased Crisps");
                    }else{
                        marker = "Sorry, not enough money";
                    }
                    break;
                case "soda":
                    if (totalMoney >= 0.8){
                        totalMoney -= 0.8;
                        System.out.println("Purchased Soda");
                    }else{
                        marker = "Sorry, not enough money";
                    }
                    break;
                case "coke":
                    if (totalMoney >= 1){
                        totalMoney -= 1;
                        System.out.println("Purchased Coke");
                    }else{
                        marker = "Sorry, not enough money";
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            if (marker.equals("Sorry, not enough money")){
                System.out.println("Sorry, not enough money");
                break;
            }else{
                input = scanner.nextLine().toLowerCase();
            }
        }
        System.out.printf("Change: %.2f%n", totalMoney);
    }
}
