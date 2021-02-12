package bg.softuni.javaadvanced;

import java.util.Scanner;

public class Ex02BookWorm_26Oct2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = scanMatrix(scanner, size);
        int[]player = locatePlayer(matrix);
        int row = player[0];
        int col = player[1];
        int[] previousStep = new int[2];

        String command = scanner.nextLine();
        while (!command.equals("end")){
            matrix[row][col] = '-';
            previousStep[0] = row;
            previousStep[1] = col;
            switch (command){
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
                default:
                    break;
            }
            if (!isInBounds(row, col, matrix)){
                row = previousStep[0];
                col = previousStep[1];
                if (text.length() > 0){
                    text.deleteCharAt(text.length() - 1);
                }
                matrix[row][col] = 'P';

            } else {
                char symbol = matrix[row][col];
                if (Character.isLetter(symbol)) {
                    text.append(symbol);
                    matrix[row][col] = 'P';
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(text.toString());
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col, char[][]matrix){
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[] locatePlayer(char[][] matrix) {
        int[] player = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P'){
                    player[0] = row;
                    player[1] = col;
                }
            }
        }
        return player;
    }

    private static char[][] scanMatrix(Scanner scanner, int size) {
        char[][]matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
