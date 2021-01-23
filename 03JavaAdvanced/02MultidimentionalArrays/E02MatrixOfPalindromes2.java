package bg.softuni.javaadvanced;

import java.util.Scanner;

public class E02MatrixOfPalindromes2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char[] current = {
                        (char)('a' + row), (char) ('a' + row + col),(char) ('a' + row)
                };
                matrix[row][col] = new String(current);
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
