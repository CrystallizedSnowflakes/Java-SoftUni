package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E11ReverseMatrixDiagonalsWhileAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        //read matrix
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
// secondary /
// 1. редовете и колоните нарастват във векторната посока => innerRow-- , innerCol ++ => while innerRow >= 0 && innerCol < n
// 2. кой е посл.елемент, който искам да разпечатам [16] => row = 0 ; col = 0

/*        int[][] matrix = {
                {16, 15, 13, 10},
                {14, 12, 9,  6},
                {11, 8,  5,  3},
                {7,  4,  2,  1}
        };
        int n = matrix.length;  */

        printSecondaryDiagonals(rows, cols, matrix);
    }

    private static void printSecondaryDiagonals(int rows, int cols, int[][] matrix) {
        int row = rows - 1; // start row
        int col = cols - 1; // start col

        while (row >= 0 ){ // свършва на последната клетка т.е. row = 0
            int innerRow = row;
            int innerCol = col;
            // печатам диагонал в while
            while (innerRow >= 0  && innerCol < cols){
                System.out.print(matrix[innerRow--][innerCol++] + " ");
            }
            System.out.println();
            col--;

            if (col < 0){ // става отрицателна почваме втората полувина
                col = 0;
                row--;
            }
        }
    }
}
