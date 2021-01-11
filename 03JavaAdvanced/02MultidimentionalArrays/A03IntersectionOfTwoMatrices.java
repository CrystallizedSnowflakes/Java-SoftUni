package bg.softuni.javaadvanced;

import java.util.Scanner;

public class A03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readCharMatrix(scanner, rows, cols);

        char[][] outputMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                outputMatrix[row][col] =
                        firstMatrix[row][col] == secondMatrix[row][col]
                                ? firstMatrix[row][col]
                                : '*';
            }
        }

        // print
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char symbol = outputMatrix[row][col];
                if (col != cols - 1) {
                    System.out.print(symbol + " "); // print cols
                } else {
                    System.out.print(symbol);
                }
            }
            System.out.println(); // going on the next row
        }
    }

    public static char[][] readMatrix(Scanner scanner, int rows, int cols){
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }

    public static char[][] readCharMatrix(Scanner scanner, int rows, int cols){
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            char[] charsArr = line.replaceAll("\\s+", "").toCharArray();
            matrix[i] = charsArr;
        }
        return matrix;
    }
}
