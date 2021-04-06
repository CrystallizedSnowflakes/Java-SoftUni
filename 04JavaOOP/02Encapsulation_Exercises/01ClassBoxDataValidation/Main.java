package e01ClassBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        // can have invalid input
        try {
            Box rectangularParallelepiped = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n"
                    + "Lateral Surface Area - %.2f%n"
                    + "Volume - %.2f%n",
                    rectangularParallelepiped.calculateSurfaceArea(),
                    rectangularParallelepiped.calculateLateralSurfaceArea(),
                    rectangularParallelepiped.calculateVolume());

        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
