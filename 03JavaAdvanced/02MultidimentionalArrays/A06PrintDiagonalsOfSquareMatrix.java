package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class A06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        //read the matrix
        // 1 2 3 2
        // 1 1 2 4
        // 1 2 1 4
        // 2 2 3 1
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int index = 0; index < size; index++) {
            System.out.print(matrix[index][index] + " "); // diagonal: 1 1 1 1
        }

//        for (int row = 0, col = 0; col < size; col++, row++) {
//            System.out.print(matrix[row][col] + " "); // diagonal: 1 1 1 1
//        }
        System.out.println();

//        for (int row = size - 1, col = 0; col < size; col++, row--) {
//            System.out.print(matrix[row][col] + " "); // diagonal: 2 2 2 2
//        }

        for (int index = 0; index < size; index++) {
            System.out.print(matrix[(size - 1) - index][index] + " "); // diagonal: 2 2 2 2
        }
    }
}
