package bg.softuni.javabasics;

import java.util.Scanner;

public class E07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double priceApartment = 0.0;
        double priceStudio = 0.0;

        switch (month){
            case "May":
            case "October":
                priceApartment = 65;
                priceStudio = 50;
                if (nights > 7 && 14 >= nights){
                    priceStudio *= 0.95;
                }else if(nights > 14){
                    priceStudio *= 0.70;
                }
                break;
            case "June":
            case "September":
                priceApartment = 68.70;
                priceStudio = 75.20;
                if (nights > 14){
                    priceStudio *= 0.80;
                }
                break;
            case "July":
            case "August":
                priceApartment = 77;
                priceStudio = 76;
                break;
        }

        if (nights > 14){
            priceApartment *= 0.9;
        }

        double finalPriceApart = nights * priceApartment;
        double finalPriceStudio = nights * priceStudio;

        System.out.printf("Apartment: %.2f lv.%n", finalPriceApart);
        System.out.printf("Studio: %.2f lv.", finalPriceStudio);
    }
}
