package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        double totalMoney = currentBalance;
        while(!input.equals("Game Time")){

            switch(input){
                case "OutFall 4":
                    if (currentBalance < 39.99){
                        System.out.println("Too Expensive");
                    }else {
                        currentBalance -= 39.99;
                        System.out.println("Bought OutFall 4");
                    }
                    break;
                case "CS: OG":
                    if (currentBalance < 15.99){
                        System.out.println("Too Expensive");
                    }else{
                        currentBalance -= 15.99;
                        System.out.println("Bought CS: OG");
                    }
                    break;
                case "Zplinter Zell":
                    if (currentBalance < 19.99){
                        System.out.println("Too Expensive");
                    }else{
                        currentBalance -= 19.99;
                        System.out.println("Bought Zplinter Zell");
                    }
                    break;
                case "Honored 2":
                    if (currentBalance < 59.99){
                        System.out.println("Too Expensive");
                    }else{
                        currentBalance -= 59.99;
                        System.out.println("Bought Honored 2");
                    }
                    break;
                case "RoverWatch":
                    if (currentBalance < 29.99){
                        System.out.println("Too Expensive");
                    }else{
                        currentBalance -= 29.99;
                        System.out.println("Bought RoverWatch");
                    }
                    break;
                case "RoverWatch Origins Edition":
                    if (currentBalance < 39.99){
                        System.out.println("Too Expensive");
                    }else{
                        currentBalance -= 39.99;
                        System.out.println("Bought RoverWatch Origins Edition");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            input = scanner.nextLine();
        }
        double totalSpent = totalMoney - currentBalance;
        if (currentBalance == 0.0){
            System.out.println("Out of money!");
        }else{
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
        }
    }
}
