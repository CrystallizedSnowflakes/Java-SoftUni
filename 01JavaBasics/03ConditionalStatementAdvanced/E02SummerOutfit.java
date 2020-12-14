package bg.softuni.javabasics;

import java.util.Scanner;

public class E02SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degree= Integer.parseInt(scanner.nextLine());
        String dayTime = scanner.nextLine();
        String outfit = "";
        String shoes = "";

        if ("Morning".equals(dayTime)){
            if (10 <= degree && degree <= 18){
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            }else if (degree <= 24){
                outfit = "Shirt";
                shoes = "Moccasins";
            }else {
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
        }else if("Afternoon".equals(dayTime)){
            if (10 <= degree && degree <= 18){
                outfit = "Shirt";
                shoes = "Moccasins";
            }else if (degree <= 24){
                outfit = "T-Shirt";
                shoes = "Sandals";
            }else{
                outfit = "Swim Suit";
                shoes = "Barefoot";
            }
        }else if("Evening".equals(dayTime)){
            if (10 <= degree){
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }

        System.out.printf("It's %d degrees, get your %s and %s.", degree, outfit, shoes);
    }
}
