package bg.softuni.javaadvanced;

import java.util.Scanner;

public class Ex02Bee_19Aug20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = readMatrix(scanner, size);
        int[] bee = locateBee(matrix);

        int flowers = 0;

        String command = scanner.nextLine();
        while (!command.equals("End")){

            matrix[bee[0]][bee[1]] = '.';

            switch (command){
                case "up":
                    bee[0]--;
                    break;
                case "down":
                    bee[0]++;
                    break;
                case "left":
                    bee[1]--;
                    break;
                case "right":
                    bee[1]++;
                    break;
            }

            if (!isInBounds(matrix, bee)) {
                System.out.println("The bee got lost!");
                break;
            }

            switch (matrix[bee[0]][bee[1]]) {
                case 'f':
                    matrix[bee[0]][bee[1]] = 'B';
                    flowers++;
                    break;
                case 'O':
                    matrix[bee[0]][bee[1]] = 'B';
                    continue;
                default:
                    matrix[bee[0]][bee[1]] = 'B';
                    break;
            }
            command = scanner.nextLine();
        }

        if (flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }
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

    private static boolean isInBounds(char[][] matrix, int[] arr) {
        int row = arr[0];
        int col = arr[1];
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[] locateBee(char[][] matrix) {
        int[] beeLocation = new int[2];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char symbol = matrix[r][c];
                if (symbol == 'B'){
                    beeLocation[0] = r;
                    beeLocation[1] = c;
                }
            }
        }
        return beeLocation;
    }

    private static char[][] readMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
