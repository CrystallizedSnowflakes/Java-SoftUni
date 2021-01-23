package bg.softuni.javaadvanced;

import java.util.ArrayList;
import java.util.Scanner;

public class E06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();
        int angleRotation = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        String input = scanner.nextLine();
        ArrayList<String> linesForMatrix = new ArrayList<>();
        int maxLength = input.length(); // first input
        while (!input.equals("END")){
            linesForMatrix.add(input);
            if (input.length() > maxLength){
                maxLength = input.length();
            }
            input = scanner.nextLine();
        }

        int rows = linesForMatrix.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < linesForMatrix.get(row).length()){ // if col is less than word size
                    matrix[row][col] = linesForMatrix.get(row).charAt(col); // get the symbol
                } else {
                    matrix[row][col] = ' '; // fill the rest cell with empty char
                }
            }
        }

        rotate(angleRotation, rows, cols, matrix);

    }

    private static void rotate(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90){ // row become col
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 180){
            for (int row = rows - 1; row >= 0 ; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 270){
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else { // angleRotation == 0 or something else
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
