package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());

        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        printClosestPointToTheCenterOfCartesianCoordinateSystem(x1, y1, x2, y2);
    }

    private static void printClosestPointToTheCenterOfCartesianCoordinateSystem(int x1, int y1, int x2, int y2){
        double r1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double r2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
        if (r1 <= r2){
            System.out.printf("(%d, %d)", x1, y1);
        }else{
            System.out.printf("(%d, %d)", x2, y2);
        }
    }
}
