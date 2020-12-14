package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = scanner.nextInt();
        int elevatorCapacity = scanner.nextInt();

        int courses = (int) Math.ceil((double)persons/elevatorCapacity);
        //int courses = persons / elevatorCapacity;
        //if (persons % elevatorCapacity != 0)
        //    courses += 1;
        System.out.println(courses);
    }
}
