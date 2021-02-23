package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E00TheMatrixRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][]matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        char fillSymbol = scanner.nextLine().charAt(0);

        int[] targetDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int targetRow = targetDimensions[0];
        int targetCol = targetDimensions[1];
        char toReplace = matrix[targetRow][targetCol];

        fillMatrix(matrix, fillSymbol, toReplace, targetRow, targetCol);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, char fillSymbol, char toReplace, int targetRow, int targetCol) {

        if (isOutOfBounds(matrix, targetRow, targetCol) ||
                matrix[targetRow][targetCol] != toReplace ||
                matrix[targetRow][targetCol] == fillSymbol){

        } else {
            // recursive call
            matrix[targetRow][targetCol] = fillSymbol;
            // move one up row - 1
            fillMatrix(matrix, fillSymbol, toReplace, targetRow - 1, targetCol);
            // move one down row + 1
            fillMatrix(matrix, fillSymbol, toReplace, targetRow + 1, targetCol);
            // move one left col - 1
            fillMatrix(matrix, fillSymbol, toReplace, targetRow, targetCol - 1);
            // move one right col + 1
            fillMatrix(matrix, fillSymbol, toReplace, targetRow, targetCol + 1);
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int targetRow, int targetCol) {
        return targetRow < 0 || targetRow >= matrix.length || targetCol < 0 || targetCol >= matrix[targetRow].length;
    }
}

