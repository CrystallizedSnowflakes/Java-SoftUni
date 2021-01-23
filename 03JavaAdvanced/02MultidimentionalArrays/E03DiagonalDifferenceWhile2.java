package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E03DiagonalDifferenceWhile2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][]matrix = new int[matrixSize][matrixSize];
        fillMatrix(scanner, matrix, matrixSize, matrixSize);

        int primarySum = calcPrimarySum(matrix);
        int secondarySum = calcSecondarySum(matrix);
        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int calcSecondarySum(int[][]matrix){
        int sum = 0;
        int row = 0, col = matrix.length - 1;
        while (col >= 0 && row < matrix.length){
            sum += matrix[row++][col--];
        }
        return sum;
    }

    private static int calcPrimarySum(int[][]matrix){
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }
        return sum;
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
