package bg.softuni.javafundamentals;

import java.util.Scanner;

public class Mid01_20Feb_NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peoplePerHourPer3Employees = scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int totalPeople = scanner.nextInt();

        int hours = 0;

        while (totalPeople > 0){
            hours++; // first hour
            if (hours % 4 != 0){
                totalPeople -= peoplePerHourPer3Employees;
            }
        }

        System.out.printf("Time needed: %dh.%n", hours);
    }
}
