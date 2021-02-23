package bg.softuni.javaadvanced;

public class A03PrintAllMatrixSecondaryDiagonals {
    public static void main(String[] args) {

        int[][] matrix = {
                {16, 15, 13, 10},
                {14, 12, 9,  6},
                {11, 8,  5,  3},
                {7,  4,  2,  1}
        };
        int n = matrix.length;
// secondary /
// 1. редовете и колоните нарастват във векторната посока => innerRow-- , innerCol ++ => while innerRow >= 0 && innerCol < n
// 2. кой е посл.елемент, който искам да разпечатам [16] => row = 0 ; col = 0

        int row = n - 1; // start row
        int col = n - 1; // start col

        while (row >= 0 ){ // свършва на последната клетка т.е. row = 0
            int innerRow = row;
            int innerCol = col;
            // печатам диагонал в while
            while (innerRow >= 0  && innerCol < n){
                System.out.print(matrix[innerRow--][innerCol++] + " ");
            }
            System.out.println();
            col--;

            if (col < 0){ // става отрицателна почваме втората полувина
                col = 0;
                row--;
            }
        }
    }
}
