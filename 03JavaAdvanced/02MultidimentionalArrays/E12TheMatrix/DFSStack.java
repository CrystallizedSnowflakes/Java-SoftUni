package E12TheMatrix;

import java.util.ArrayDeque;

public class DFSStack implements Strategy{
    @Override
    public void solve(int row, int col, char colorToReplace, char fillColor, Matrix matrix) {
        ArrayDeque<int[]> indexes = new ArrayDeque<>();

        indexes.push(new int[]{row, col});

        while (!indexes.isEmpty()) {
            int[] rowAndCol = indexes.pop();
            row = rowAndCol[0];
            col = rowAndCol[1];
            matrix.setCell(rowAndCol[0], rowAndCol[1], fillColor);

            if (!matrix.isOutOfBounds(row + 1, col)
                    && matrix.getCell(row + 1, col) == colorToReplace) {
                indexes.push(new int[]{row + 1, col});
            }
            if (!matrix.isOutOfBounds(row - 1, col)
                    && matrix.getCell(row - 1, col) == colorToReplace) {
                indexes.push(new int[]{row - 1, col});
            }
            if (!matrix.isOutOfBounds(row, col + 1)
                    && matrix.getCell(row, col + 1) == colorToReplace) {
                indexes.push(new int[]{row, col + 1});
            }
            if (!matrix.isOutOfBounds(row, col - 1)
                    && matrix.getCell(row, col - 1) == colorToReplace) {
                indexes.push(new int[]{row, col - 1});
            }
        }
    }
}
