package bg.softuni.javafundamentals;

import java.util.Scanner;

public class Mid01_20Jul_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityPerHour = scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int studentsRemaining = scanner.nextInt();

        int hours = 0;
        while (studentsRemaining > 0){
            hours++; // first hour
            if (hours % 4 != 0){
                studentsRemaining -= capacityPerHour;
            }
        }

        System.out.printf("Time needed: %dh.%n", hours);
    }
}
