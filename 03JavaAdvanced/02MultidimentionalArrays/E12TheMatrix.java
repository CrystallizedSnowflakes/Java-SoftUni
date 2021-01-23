package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .findFirst().orElse(0);

        char[][] matrix = readCharMatrix(scanner, rows);

        char fillChar = scanner.nextLine().trim().charAt(0);

        int[] startPosition = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startRow = startPosition[0];
        int startCol = startPosition[1];

        char startChar = matrix[startRow][startCol];

        fill(matrix, startRow, startCol, fillChar, startChar);

        System.out.println(Arrays.stream(matrix)
                .map(String::new)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    public static char[][] readCharMatrix(Scanner scanner, int rows){
        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            char[] charsArr = line.replaceAll("\\s+", "").toCharArray();
            matrix[i] = charsArr;
        }
        return matrix;
    }

    private static void fill(char[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar) {
            return;
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) {
            fill(matrix, row + 1, col, fillChar, startChar);
        }

        if (row - 1 >= 0) {
            fill(matrix, row - 1, col, fillChar, startChar);
        }

        if (col + 1 < matrix[row].length) {
            fill(matrix, row, col + 1, fillChar, startChar);
        }

        if (col - 1 >= 0) {
            fill(matrix, row, col - 1, fillChar, startChar);
        }
    }
}
