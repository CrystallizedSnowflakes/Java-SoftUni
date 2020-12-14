package bg.softuni.javabasics;

import java.util.Scanner;

public class E06CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int pastryCooks = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int waffles = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());

        double cakePricePerDay = cakes * 45.0;
        double wafflesPricePerDay = waffles * 5.80;
        double pancakesPricePerDay = pancakes * 3.20;

        double pastryCooksPricePerDay = cakePricePerDay + wafflesPricePerDay + pancakesPricePerDay;
        double totalPastryCooksPrice = pastryCooks * pastryCooksPricePerDay;
        double totalPriceCharityCampaign = days * totalPastryCooksPrice;
        // 1/8 from totalPriceCharityCampaign = ( 1/8 * totalPriceCharityCampaign) = (totalPriceCharityCampaign /8)
        double costs = totalPriceCharityCampaign / 8;
        double finalPrice = totalPriceCharityCampaign - costs;

        System.out.printf("%.2f", finalPrice);
    }
}
