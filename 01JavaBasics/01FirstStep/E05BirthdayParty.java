package bg.softuni.javabasics;

import java.util.Scanner;

public class E05BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hallPrice = Integer.parseInt(scanner.nextLine());
        // animator = 1/3 from hall = (hall * 1/3) = (hall / 3)
        double animatorPrice = hallPrice / 3.0;
        // cake = 20% from hall = (20/100 from hall) = (0.2 * hall)
        double cakePrice = 0.2 * hallPrice;
        // drinks = cake - 45% = cake - 0.45 * cake
        double drinksPrice = cakePrice - 0.45 * cakePrice;
        double needBudget = hallPrice + cakePrice + drinksPrice + animatorPrice;

        System.out.println(needBudget);
    }
}
