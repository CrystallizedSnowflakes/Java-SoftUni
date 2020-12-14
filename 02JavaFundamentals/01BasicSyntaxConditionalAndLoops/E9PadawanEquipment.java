package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E9PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = scanner.nextDouble();
        int students = scanner.nextInt();
        double sabrePrice = scanner.nextDouble();
        double robePrice = scanner.nextDouble();
        double beltPrice = scanner.nextDouble();

        double extraSabres = Math.ceil(students * 0.10);
        double sabreCosts = sabrePrice * (students + extraSabres);

        double robeCosts = robePrice * students;

        int freeBelts = 0;
        if (students % 6 != 1){
            freeBelts = students / 6;
        }
        double beltCosts = beltPrice * (students - freeBelts);

        double calculatedPriceOfEquipment = sabreCosts + robeCosts + beltCosts;
        double neededMoney = calculatedPriceOfEquipment - money;

        if (calculatedPriceOfEquipment <= money){
            System.out.printf("The money is enough - it would cost %.2flv.", calculatedPriceOfEquipment);
        }else{
            System.out.printf("Ivan Cho will need %.2flv more.", neededMoney);
        }

    }
}
