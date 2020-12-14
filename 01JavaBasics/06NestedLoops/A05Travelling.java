package bg.softuni.javabasics;

import java.util.Scanner;

public class A05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String destination = scanner.nextLine();
            if ("End".equals(destination)){
                break;
            }
            double budget = Double.parseDouble(scanner.nextLine());
            double savings = 0.0;

            while (savings < budget){
                double money = Double.parseDouble(scanner.nextLine());
                savings += money;
                if (savings >= budget){
                    System.out.printf("Going to %s!%n", destination);
                }
            }
        }
    }
}
