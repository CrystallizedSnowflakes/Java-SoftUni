package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int group = Integer.parseInt(sc.nextLine());
        String typeOfGroup = sc.nextLine().toLowerCase();
        String weekday = sc.nextLine().toLowerCase();

        double totalPrice;

        switch (typeOfGroup){
            case "students":
                switch (weekday){
                    case "friday":
                        totalPrice = group * 8.45;
                        break;
                    case "saturday":
                        totalPrice = group * 9.80;
                        break;
                    case "sunday":
                        totalPrice = group * 10.46;
                        break;
                    default:
                        totalPrice = -1;
                        break;
                }
                if (group >= 30){
                    totalPrice *= 0.85; // discount 15% off | 100-15=85
                }
                break;
            case "business":
                if (group >= 100){
                    group -=10;
                }
                switch (weekday){
                    case "friday":
                        totalPrice = group * 10.90;
                        break;
                    case "saturday":
                        totalPrice = group * 15.60;
                        break;
                    case "sunday":
                        totalPrice = group * 16;
                        break;
                    default:
                        totalPrice = -1;
                        break;
                }
                break;
            case "regular":
                switch (weekday){
                    case "friday":
                        totalPrice = group * 15;
                        break;
                    case "saturday":
                        totalPrice = group * 20;
                        break;
                    case "sunday":
                        totalPrice = group * 22.50;
                        break;
                    default:
                        totalPrice = -1;
                        break;
                }
                if (10 <= group && group <= 20){
                    totalPrice *=  0.95; // discount 5% off | 100-5=95
                }
                break;
            default:
                totalPrice = -1;
                break;
        }
        if (totalPrice != -1) {
            System.out.printf("Total price: %.2f", totalPrice);
        }else{
            System.out.println("Error!");
        }
    }
}
