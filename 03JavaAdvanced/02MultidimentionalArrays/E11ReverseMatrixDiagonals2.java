package bg.softuni.javaadvanced;

import java.util.*;

public class E11ReverseMatrixDiagonals2 {
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

        ArrayDeque<ArrayList<Integer>> matrixList = new ArrayDeque<>();

        //int M = matrix.length;
        //int N = matrix[0].length;

        // print "/" diagonal for upper-left half of the matrix
        for (int r = 0; r < matrix.length; r++)
        {
            ArrayList<Integer> lists = new ArrayList<>();
            // start from each cell of first column of the matrix
            for (int row = r, col = 0; col < matrix[0].length && row >= 0; row--, col++) {
                lists.add(matrix[row][col]);
            }
            matrixList.push(lists);
        }

        // print "/" diagonal for lower-right half of the matrix
        for (int c = 1; c < matrix[0].length; c++)
        {
            ArrayList<Integer> lists = new ArrayList<>();
            // start from each cell of the last row
            for (int row = matrix.length - 1, col = c; col < matrix[0].length && row >= 0; row--, col++) {
                lists.add(matrix[row][col]);
            }
            matrixList.push(lists);
        }

        printListMatrix(matrixList);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printListMatrix(ArrayDeque<ArrayList<Integer>> matrixList){
        while (!matrixList.isEmpty()){
            ArrayList<Integer> list = matrixList.pop();
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
