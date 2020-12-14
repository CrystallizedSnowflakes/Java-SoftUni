package bg.softuni.javabasics;

import java.util.Scanner;

public class A08PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogs = Integer.parseInt(scanner.nextLine());
        int animals = Integer.parseInt(scanner.nextLine());

        double sum = dogs * 2.50 + animals * 4.00;
        System.out.printf("%.1f lv.", sum);
    }
}
