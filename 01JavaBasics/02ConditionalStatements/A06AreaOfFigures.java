package bg.softuni.javabasics;

import java.util.Scanner;

public class A06AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFigure = scanner.nextLine();

        if (typeOfFigure.equals("square")){
            double squareSide = Double.parseDouble(scanner.nextLine());
            double squareArea = squareSide * squareSide;
            System.out.printf("%.3f", squareArea);
        }else if(typeOfFigure.equals("rectangle")){
            double rectangleLength = Double.parseDouble(scanner.nextLine());
            double rectangleWidth = Double.parseDouble(scanner.nextLine());
            double rectangleArea = rectangleLength * rectangleWidth;
            System.out.printf("%.3f", rectangleArea);
        }else if (typeOfFigure.equals("circle")){
            double radius = Double.parseDouble(scanner.nextLine());
            double circleArea = Math.PI * radius * radius;
            System.out.printf("%.3f", circleArea);
        }else{ //triangle
            double triangleBase = Double.parseDouble(scanner.nextLine());
            double triangleHeight = Double.parseDouble(scanner.nextLine());
            double triangleArea = (triangleBase * triangleHeight) / 2.0;
            System.out.printf("%.3f", triangleArea);
        }
    }
}
