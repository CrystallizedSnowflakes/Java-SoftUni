package bg.softuni.javabasics;

import java.util.Scanner;

public class A05Travelling2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!"End".equals(destination)){
            double neededMoney = Double.parseDouble(scanner.nextLine());
            double savings = 0;
            while (savings < neededMoney){
                double moneyToSave = Double.parseDouble(scanner.nextLine());
                savings += moneyToSave;
            }

            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}
