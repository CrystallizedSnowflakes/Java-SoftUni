package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E04MaximalSumByCenterMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][]matrix = new int[rows][cols];

        //read
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner);
        }

        int maxSum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currentSum = calcMatrixSum(matrix, row, col);
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    // save matrix
                    indexRow = row;
                    indexCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMaxSubMatrix(matrix, indexRow, indexCol);
    }

    private static void printMaxSubMatrix(int[][] matrix, int indexRow, int indexCol) {
        for (int row = indexRow - 1; row <= indexRow + 1; row++) {
            for (int col = indexCol - 1; col <= indexCol + 1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    // coordinate center of a matrix
    private static int calcMatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;
        sum += matrix[row][col];
        // right
        sum += matrix[row][col + 1];
        // left
        sum += matrix[row][col - 1];
        // up
        sum += matrix[row - 1][col];
        // down
        sum += matrix[row + 1][col];
        // UpRight
        sum += matrix[row - 1][col + 1];
        // UpLeft
        sum += matrix[row - 1][col - 1];
        // DownRight
        sum += matrix[row + 1][col + 1];
        // DownLeft
        sum += matrix[row + 1][col - 1];
        return sum;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
