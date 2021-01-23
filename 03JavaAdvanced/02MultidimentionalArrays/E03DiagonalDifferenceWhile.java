package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E03DiagonalDifferenceWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][]matrix = new int[matrixSize][matrixSize];
        fillMatrix(scanner, matrix, matrixSize, matrixSize);
        int mainDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        int row = 0;
        int col = 0;
        while (row < matrixSize){
            mainDiagonalSum += matrix[row++][col++]; // [0][0] the number is on the main diagonal
        }

        for (int rowS = matrixSize - 1, cols = 0; rowS >=0; rowS--, cols++) {
            secondaryDiagonalSum += matrix[rowS][cols]; // the number is on the secondary diagonal
        }

        System.out.println(Math.abs(mainDiagonalSum - secondaryDiagonalSum));
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
