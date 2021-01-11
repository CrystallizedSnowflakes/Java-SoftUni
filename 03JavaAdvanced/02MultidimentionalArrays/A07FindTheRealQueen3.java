package bg.softuni.javaadvanced;

import java.util.Scanner;

public class A07FindTheRealQueen3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 8;
        char[][] board = new char[size][size];

        for (int r = 0; r < size; r++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int c = 0; c < line.length; c++) {
                board[r][c] = line[c].charAt(0);
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == 'q'){
                   boolean isColValid = checkQueenCol(board, col);
                   boolean isRowValid = checkQueenRow(board, row);
                   boolean isMainDiagonalValidUpLeft = checkMainDiagonalUpLeft(board, row, col);
                   boolean isMainDiagonalValidDownRight = checkMainDiagonalDownRight(board, row, col);
                   boolean isSecondaryDiagonalValidUpRight = checkSecondaryDiagonalUpRight(board, row, col);
                   boolean isSecondaryDiagonalValidDownLeft = checkSecondaryDiagonalDownLeft(board, row, col);

                   if (isColValid && isRowValid && isMainDiagonalValidUpLeft && isMainDiagonalValidDownRight
                   && isSecondaryDiagonalValidUpRight && isSecondaryDiagonalValidDownLeft){
                       System.out.println(row + " " + col);
                       return;
                   }
                }
            }
        }
    }

    private static boolean checkSecondaryDiagonalDownLeft(char[][] board, int row, int col) {
        row++;
        col--;
        while (row < board.length && col >= 0){
            if (board[row++][col--] == 'q'){
                return false;
            }
        }
        return true;
    }

    private static boolean checkSecondaryDiagonalUpRight(char[][] board, int row, int col) {
        row--;
        col++;
        while (row >= 0 && col < board.length){
            if (board[row--][col++] == 'q'){
                return false;
            }
        }
        return true;
    }

    private static boolean checkMainDiagonalDownRight(char[][] board, int row, int col) {
        row++;
        col++;
        while (row < board.length && col < board.length){
            if (board[row++][col++] == 'q'){
                return false;
            }
        }
        return true;
    }

    private static boolean checkMainDiagonalUpLeft(char[][] board, int row, int col) {
        row--;
        col--;
        while (row >= 0 && col >= 0){
            if (board[row--][col--] == 'q'){
                return false;
            }
        }
        return true;
    }

    private static boolean checkQueenRow(char[][] board, int row) {
        int queens = 0;
        for (int col = 0; col < board.length; col++) {
            char symbol = board[row][col];
            if (symbol =='q'){
                queens++;
            }
        }
        return queens == 1;
    }

    private static boolean checkQueenCol(char[][] board, int col) {
        int queens = 0;
        for (int row = 0; row < board.length; row++) {
            char symbol = board[row][col];
            if (symbol =='q'){
                queens++;
            }
        }
        return queens == 1;
    }
}
