package bg.softuni.javabasics;

import java.util.Scanner;

public class E02RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radians = Double.parseDouble(scanner.nextLine());
        double degrees = Math.floor(radians * 180 / Math.PI);
        System.out.printf("%.0f", degrees);
    }
}
