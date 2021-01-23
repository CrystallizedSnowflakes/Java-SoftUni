package bg.softuni.javaadvanced;

import java.util.Scanner;

public class E09ParkingSystem2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        byte[][] matrix = new byte[rows][];             // define array with empty arrays
        // 0 for empty, 1 for occupied

        String command;
        while (!(command = scanner.nextLine()).equals("stop")) {
            String[] data = command.split("\\s+");
            int entrance = Integer.parseInt(data[0]);
            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[2]);

            int steps = Math.abs(entrance - row) + 1;   // initial steps in first (0) column
            if (matrix[row] == null) {                   // if current array is empty
                matrix[row] = new byte[columns];        // add new byte array filled with 0
            }

            if (matrix[row][col] == 0){
                matrix[row][ col] = 1;
                steps += col;                           // add steps in the row to the initial steps
                System.out.println(steps);
            }
            else{
                int cnt = 1;                            // counter for cells
                while (true)
                {
                    int lowerCell = col - cnt;
                    int upperCell = col + cnt;

                    if (lowerCell < 1 && upperCell > columns - 1){  // if cells are out of bounds
                        System.out.printf("Row %d full%n", row);
                        break;
                    }
                    if (lowerCell > 0 && matrix[row][lowerCell] == 0){       // if cell is inside of the row
                        matrix[row][lowerCell] = 1;                          // and free
                        steps += lowerCell;
                        System.out.println(steps);
                        break;
                    }
                    if ( upperCell < columns && matrix[row][upperCell] == 0){ // if cell is inside of the row
                        matrix[row][upperCell] = 1;                           // and is free
                        steps += upperCell;
                        System.out.println(steps);
                        break;
                    }
                    cnt++;
                }
            }
        }
    }
}
