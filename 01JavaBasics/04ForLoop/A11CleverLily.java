package bg.softuni.javabasics;

import java.util.Scanner;

public class A11CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int pricePerToy = Integer.parseInt(scanner.nextLine());

        double money = 0.0;

        for (int i = 1; i <=  age; i++) {
            if (i % 2 == 0){
                money += 10.00 * i / 2;
                money -= 1;
            }else{
                money += pricePerToy;
            }
        }

        if(money >= washingMachinePrice){
            double moneyLeft = money - washingMachinePrice;
            System.out.printf("Yes! %.2f", moneyLeft);
        }else{
            double neededMoney = washingMachinePrice - money;
            System.out.printf("No! %.2f", neededMoney);
        }
    }
}
