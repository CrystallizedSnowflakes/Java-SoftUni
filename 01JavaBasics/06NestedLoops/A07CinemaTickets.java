package bg.softuni.javabasics;

import java.util.Scanner;

public class A07CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        int totalTickets = 0;
        int standard = 0;
        int student = 0;
        int kid = 0;
        while (!"Finish".equals(movie)){
            int seats = Integer.parseInt(scanner.nextLine());

            int ticketsPerMovie = 0;
            while (seats > ticketsPerMovie){
                String type = scanner.nextLine();
                if ("End".equals(type)){
                    break;
                }
                switch (type){
                    case "student":
                        student++;
                        break;
                    case "standard":
                        standard++;
                        break;
                    case "kid":
                        kid++;
                        break;
                }
                ticketsPerMovie++;
            }
            totalTickets += ticketsPerMovie;
            double percentage = (double) ticketsPerMovie / seats * 100;
            System.out.printf("%s - %.2f%% full.%n", movie, percentage);
            movie = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", totalTickets);
        double percentageStudent = (double)student / totalTickets * 100;
        System.out.printf("%.2f%% student tickets.%n", percentageStudent);
        double percentageStandard = (double) standard / totalTickets * 100;
        System.out.printf("%.2f%% standard tickets.%n", percentageStandard);
        double percentageKid = (double)kid / totalTickets * 100;
        System.out.printf("%.2f%% kids tickets.", percentageKid);
    }
}
