package bg.softuni.javabasics;

import java.util.Scanner;

public class A08CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String weekDay = scanner.nextLine();
        switch (weekDay){
            case "Monday":
            case "Tuesday":
            case "Friday":
                System.out.println(12);
                break;
            case "Wednesday":
            case "Thursday":
                System.out.println(14);
                break;
            case "Saturday":
            case "Sunday":
                System.out.println(16);
                break;
        }
    }
}
