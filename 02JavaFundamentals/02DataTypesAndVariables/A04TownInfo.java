package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A04TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        int population = scanner.nextInt();
        int area = scanner.nextInt();

        System.out.printf("Town %s has population of %d and area %d square km.", town, population, area);
    }
}
