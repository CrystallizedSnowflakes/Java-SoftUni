package bg.softuni.javaadvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        // read matrix
        // 3
        // 1 2 4
        // 4 6 7
        // 8 9 4
        // 1 0 -> 4
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner, "\\s+");
        }
        int[] valueIndexes = readArray(scanner, "\\s+");
        int wrongValue = matrix[valueIndexes[0]][valueIndexes[1]];

        List<int[]> indexes = new ArrayList<>(); // [0][2]
        List<Integer> correctValues = new ArrayList<>(); // 9 -> 7 + 2

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue){
                    indexes.add(new int[]{row, col}); // here are the current 2 indexes in matrix of wrongValue
                    int validValue = getCorrectValue(matrix, row, col);
                    correctValues.add(validValue);
                }
            }
        }

        // fill the matrix with the correct values
        for (int i = 0; i < indexes.size(); i++) {
            int[] rowAndCol = indexes.get(i); // [0][2]
            // on [0][2] in matrix puts correctValue 9
            matrix[rowAndCol[0]][rowAndCol[1]] = correctValues.get(i);
        }
        
        // print matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getCorrectValue(int[][] matrix, int row, int col) {
        int sum = 0;
        int wrongValue = matrix[row][col];
        // up
        if (isInBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue){
            sum += matrix[row + 1][col];
        }
        // down
        if (isInBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongValue){
            sum += matrix[row - 1][col];
        }
        // right
        if (isInBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongValue){
            sum += matrix[row][col + 1];
        }
        // left
        if (isInBounds(matrix, row, col - 1) && matrix[row][col - 1] != wrongValue){
            sum += matrix[row][col - 1];
        }
        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean isOutOfBounds(int[][] matrix, int row, int col){
        return !isInBounds(matrix, row, col);
    }

    private static int[] readArray(Scanner scanner, String separator){
        return Arrays.stream(scanner.nextLine().split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
