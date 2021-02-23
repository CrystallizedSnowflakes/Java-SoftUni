package bg.softuni.javaadvanced;

public class A01PrintAllMatrixPrimaryDiagonals {
    public static void main(String[] args) {
        int[][] matrix = {
                {7,  4,  2,  1},
                {11, 8,  5,  3},
                {14, 12, 9,  6},
                {16, 15, 13, 10}
        };
        int n = matrix.length;
// main \
// 1. редовете и колоните нарастват във векторната посока => innerRow++ , innerCol ++ => while innerRow < n && innerCol < n
// 2. кой е посл.елемент, който искам да разпечатам [16] => row = n - 1 ; col = 0

        int row = 0;        // start row
        int col = n - 1;    // start col

        while (row < n){
            int innerRow = row;
            int innerCol = col;
            // печатам диагонал в while
            while (innerRow < n && innerCol < n){
                System.out.print(matrix[innerRow++][innerCol++] + " ");
            }
            System.out.println();
            col--;
            if (col < 0){ // става отрицателна
                col = 0;
                row++;
            }
        }
    }
}
