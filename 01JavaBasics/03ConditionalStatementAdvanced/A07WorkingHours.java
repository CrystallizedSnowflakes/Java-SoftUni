package bg.softuni.javabasics;

import java.util.Scanner;

public class A07WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String weekDay = scanner.nextLine();

        boolean isOpen = false;
        if (10 <= hour && hour <= 18){
            isOpen = true;
        }
        switch (weekDay){
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
            case "Saturday":
                if (isOpen){
                    System.out.println("open");
                }else{
                    System.out.println("closed");
                }
                break;
            case "Sunday":
                System.out.println("closed");
                break;
        }
    }
}
