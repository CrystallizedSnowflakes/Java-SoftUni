package bg.softuni.javaadvanced;

import java.util.Scanner;

public class Ex02Snake1_28Jun2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = scanMatrix(scanner, size);
        int[]snake = locateSnake(matrix);
        int row = snake[0];
        int col = snake[1];
        int food = 0;

        while (food < 10) {
            String command = scanner.nextLine();
            matrix[row][col] = '.';
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
                break;
            }
            char symbol = matrix[row][col];
            switch (symbol){
                case '*':
                    matrix[row][col] = 'S';
                    food++;
                    break;
                case 'B':
                    matrix[row][col] = '.';
                    snakeGoesOutOnBorrow(matrix, snake);
                    row = snake[0];
                    col = snake[1];
                    matrix[row][col] = 'S';
                break;
                default:
                    matrix[row][col] = 'S';
                    break;
            }
        }

        if (food == 10){
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", food);
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

    private static void snakeGoesOutOnBorrow(char[][] matrix, int[]snake) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B'){
                    snake[0] = row;
                    snake[1] = col;
                }
            }
        }
    }

    private static boolean isInBounds(int row, int col, char[][]matrix){
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[] locateSnake(char[][] matrix) {
        int[] snake = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S'){
                    snake[0] = row;
                    snake[1] = col;
                }
            }
        }
        return snake;
    }

    private static char[][] scanMatrix(Scanner scanner, int size) {
        char[][]matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
