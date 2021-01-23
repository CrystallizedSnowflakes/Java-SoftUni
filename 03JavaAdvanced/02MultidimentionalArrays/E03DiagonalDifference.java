package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][]matrix = new int[matrixSize][matrixSize];
        fillMatrix(scanner, matrix, matrixSize, matrixSize);
        int sumMainDiagonal = 0;
        int sumSecondaryDiagonal = 0;

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                int number = matrix[row][col];
                if (row == col){ // [0][0] the number is on the main diagonal
                    sumMainDiagonal += number;
                }
                if (col == matrixSize - row - 1){ // the number is on the secondary diagonal
                sumSecondaryDiagonal += number;
                }
            }
        }
        System.out.println(Math.abs(sumMainDiagonal - sumSecondaryDiagonal));
    }
    // read
    public static void fillMatrix(Scanner scanner, int[][]matrix, int rows, int cols){
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
