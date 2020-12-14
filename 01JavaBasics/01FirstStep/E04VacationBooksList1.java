package bg.softuni.javabasics;

import java.util.Scanner;

public class E04VacationBooksList1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pages = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int hours = pages / pagesPerHour;
        int hoursPerDay = hours / days;

        System.out.println(hoursPerDay);
    }
}
