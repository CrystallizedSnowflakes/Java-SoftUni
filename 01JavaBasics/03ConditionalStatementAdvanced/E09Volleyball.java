package bg.softuni.javabasics;

import java.util.Scanner;

public class E09Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine();
        int holidays = Integer.parseInt(scanner.nextLine());
        int gamesAtHome = Integer.parseInt(scanner.nextLine());

        int sofiaWeekend = 48 - gamesAtHome;
        double gamesInSofia = sofiaWeekend * (3.0 / 4);
        double gamesDuringHolidays = holidays * (2.0 / 3);

        double games = gamesInSofia + gamesAtHome + gamesDuringHolidays;

        if (year.equals("leap")){
            games *= 1.15;
        }

        System.out.printf("%.0f", Math.floor(games));
    }
}
