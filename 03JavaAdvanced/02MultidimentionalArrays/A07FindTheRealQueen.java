package bg.softuni.javaadvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        char validQueen;

        // read matrix
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            char[] charsArr = line.replaceAll("\\s+", "").toCharArray();
            matrix[row] = charsArr;
        }

        List<int[]> indexes = new ArrayList<>(); // [4][3]

        // print matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q'){
                    // row
                    boolean isTheQueen = true;
                    int countRow = 0;
                    for (int col1 = 0; col1 < matrix[row].length; col1++) {
                        if(matrix[row][col1] == 'q'){
                            countRow++;
                        }
                        if (countRow > 1){
                            isTheQueen = false;
                            break;
                        }
                    }
                    // col
                    int countCol = 0;
                    for (int row1 = 0; row1 < matrix.length; row1++) {
                        if(matrix[row1][col] == 'q'){
                            countCol++;
                        }
                        if (countCol > 1){
                            isTheQueen = false;
                            break;
                        }
                    }
                    //diagonal left up
                    int d1Row = row - 1;
                    int d1Col = col - 1;
                    while (d1Row >= 0 && d1Col >= 0){
                        if (matrix[d1Row][d1Col] == 'q'){
                            isTheQueen = false;
                            break;
                        }
                        d1Row--;
                        d1Col--;
                    }
                    //diagonal left down
                    int d2Row = row + 1;
                    int d2Col = col - 1;
                    while (d2Row < matrix.length && d2Col >= 0){
                        if (matrix[d2Row][d2Col] == 'q'){
                            isTheQueen = false;
                            break;
                        }
                        d2Row++;
                        d2Col--;
                    }
                    //diagonal right up
                    int d3Row = row - 1;
                    int d3Col = col + 1;
                    while (d3Row >= 0 && d3Col < matrix.length){
                        if (matrix[d3Row][d3Col] == 'q'){
                            isTheQueen = false;
                            break;
                        }
                        d3Row--;
                        d3Col++;
                    }
                    //diagonal right down
                    int d4Row = row + 1;
                    int d4Col = col + 1;
                    while (d4Row < matrix.length && d4Col < matrix.length){
                        if (matrix[d4Row][d4Col] == 'q'){
                            isTheQueen = false;
                            break;
                        }
                        d4Row++;
                        d4Col++;
                    }
                    if (isTheQueen) {
                        indexes.add(new int[]{row, col});
                    }
                }
            }
        }
        for (int[] index : indexes) {
            System.out.print(index[0] + " " + index[1]);
        }
    }
}
