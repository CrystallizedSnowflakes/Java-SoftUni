package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E11ReverseMatrixDiagonalsWhile {
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
        //printMatrix(matrix);

        ArrayDeque<ArrayList<Integer>> matrixStack = new ArrayDeque<>();

        //int M = matrix.length;
        //int N = matrix[0].length;

        // print "/" diagonal for upper-left half of the matrix

        for (int r = 0; r < matrix.length; r++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            // start from each cell of first column of the matrix
            int row = r;
            int col = 0;
            while (col < matrix[0].length && row >= 0){
                list.add(matrix[row][col]);
                row--;
                col++;
            }
            matrixStack.push(list);
        }

        // print "/" diagonal for lower-right half of the matrix
        for (int c = 1; c < matrix[0].length; c++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            // start from each cell of the last row
            int row = matrix.length - 1;
            int col = c;
            while (col < matrix[0].length && row >= 0){
                list.add(matrix[row][col]);
                row--;
                col++;
            }
            matrixStack.push(list);
        }

        printListMatrix(matrixStack);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printListMatrix(ArrayDeque<ArrayList<Integer>> matrixStack){
        while (!matrixStack.isEmpty()){
            ArrayList<Integer> lists = matrixStack.pop();
            for (Integer list : lists) {
                System.out.print(list + " ");
            }

            System.out.println();
        }
    }
}
