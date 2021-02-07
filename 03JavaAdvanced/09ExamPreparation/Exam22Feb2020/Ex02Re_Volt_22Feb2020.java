package bg.softuni.javaadvanced;

import java.util.Scanner;

public class Ex02Re_Volt_22Feb2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size  = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = scanMatrix(scanner, size);
        int[] startCell = findStartPosition(matrix);
        int row = startCell[0];
        int col = startCell[1];
        int[] previousStep = new int[2];

        boolean isReachedF = false;

        String command = "";
        while (countOfCommands-- > 0 && matrix[row][col] != 'F'){

            if (matrix[row][col] != 'B' && matrix[row][col] != 'T'){
                matrix[row][col] = '-';
                command = scanner.nextLine();
            }

            previousStep[0] = row;
            previousStep[1] = col;

            switch (command) {
                case "up":
                    row--;
                    if (row < 0){
                        row = matrix.length - 1;
                    }
                    break;
                case "down":
                    row++;
                    if (row >= matrix.length){
                        row = 0;
                    }
                    break;
                case "left":
                    col--;
                    if (col < 0){
                        col = matrix[row].length - 1;
                    }
                    break;
                case "right":
                    col++;
                    if (col >= matrix[row].length){
                        col = 0;
                    }
                    break;
                default:
                    break;
            }

            switch (matrix[row][col]) {
                case 'F':
                    matrix[row][col] = 'f';
                    isReachedF = true;
                    break;
                case 'B':
                    countOfCommands++;
                    continue;
                case 'T':
                    row = previousStep[0];
                    col = previousStep[1];
                    break;
                default:
                    matrix[row][col] = 'f';
                    break;
            }

            if (isReachedF) {
                break;
            }
        }

        if (isReachedF){
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static int[] findStartPosition(char[][] matrix) {
        int[] startCell = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 'f'){
                    startCell[0] = row;
                    startCell[1] = col;
                }
            }
        }
        return startCell;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] scanMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
