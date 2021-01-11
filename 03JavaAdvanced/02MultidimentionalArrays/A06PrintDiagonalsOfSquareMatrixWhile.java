package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class A06PrintDiagonalsOfSquareMatrixWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        //read the matrix
        // 1 2 3 8
        // 1 3 6 5
        // 1 4 6 5
        // 2 2 3 9
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = 0;
        int col = 0;
        while (row < size && col < size){
            System.out.print(matrix[row][col] + " "); // 1 3 6 9
            row++;
            col++;
        }
        System.out.println();

        row = size - 1;
        col = 0;
        while (row >= 0 && col < size){
            System.out.print(matrix[row][col] + " "); // 2 4 6 8
            row--;
            col++;
        }

        System.out.println();

        row = size - 1;
        col = size - 1;
        while (row >= 0 && col >= 0){
            System.out.print(matrix[row][col] + " "); // 9 6 3 1
            row--;
            col--;
        }

        System.out.println();

        row = 0;
        col = size - 1;
        while (row < size && col >= 0){
            System.out.print(matrix[row][col] + " "); // 9 6 3 1
            row++;
            col--;
        }
    }
}
