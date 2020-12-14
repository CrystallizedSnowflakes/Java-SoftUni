package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        double rectangleArea = getRectangleArea(width, height);
        System.out.println((int)rectangleArea);

    }

    //II.	Returning Values and Overloading
    private static double getRectangleArea(double width, double height) {
        return width * height;
    }
}
