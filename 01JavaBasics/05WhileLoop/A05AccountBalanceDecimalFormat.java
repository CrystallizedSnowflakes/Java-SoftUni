package bg.softuni.basics;

import java.util.Scanner;

public class A05AccountBalanceDecimalFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double balance = 0.0;
        while (!input.equals("NoMoreMoney")){
            double money = Double.parseDouble(input);
            if (money < 0){
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", money);
            //System.out.println("Increase: " + new DecimalFormat("0.##").format(money));

            balance += money;
            input = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", balance);
    }
}
