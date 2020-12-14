package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = Integer.parseInt(scanner.nextLine());

        String[] daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (1 <= day && day <= 7){
            System.out.println(daysOfWeek[day - 1]);
        }else{
            System.out.println("Invalid day!");
        }
    }
}
