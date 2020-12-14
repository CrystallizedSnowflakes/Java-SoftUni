package bg.softuni.javabasics;

import java.util.Scanner;

public class A13SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int nights = days - 1;
        String accommodation = scanner.nextLine();
        String evaluation = scanner.nextLine();

        double price = 0.0;

        switch (accommodation){
            case "room for one person":
                price = 18.0 * nights;
                break;
            case "apartment":
                price =  25.0 * nights;
                if (nights < 10){
                    price *= 0.70;
                }else if(nights <= 15){
                    price *= 0.65;
                }else{
                    price /= 2.0;
                }
                break;
            case "president apartment":
                price = 35.0 * nights;
                if (days < 10){
                    price *= 0.90;
                }else if(days <= 15){
                    price *= 0.85;
                }else{
                    price *= 0.80;
                }
                break;
            default:
                break;
        }
        if (evaluation.equals("positive")){
            price += price * 0.25;
        }else if(evaluation.equals("negative")){
            price *= 0.90;
        }
        System.out.printf("%.2f", price);
    }
}
