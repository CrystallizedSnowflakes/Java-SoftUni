package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String input = scanner.nextLine();

        int[][] parking = new int[rows][cols];

        while (!input.equals("stop")){
            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int entryRow = tokens[0];
            int spotRow = tokens[1];
            int spotCol = tokens[2];

            int distance = Math.abs(entryRow - spotRow) + 1;

            if (parking[spotRow][spotCol] == 0){
                // The spot is free and I can park there
                distance += spotCol;
                parking[spotRow][spotCol] = 1;
                System.out.println(distance);

            } else { // parking[spotRow][spotCol] == 1
                // currentSpot is busy

                int count = 1;

                // leftCol > 0 && rightCol < cols - 1
                while (true) {
                    int leftCol = spotCol - count;
                    int rightCol = spotCol + count;

                    if (leftCol < 1 && rightCol > cols - 1){ // out of bounds
                        System.out.printf("Row %d full%n", spotRow);
                        break;
                    }
                    // check left neighbour
                    if (leftCol > 0 && parking[spotRow][leftCol] == 0) {
                        // The left spot is free and I can park there
                        distance += leftCol;
                        parking[spotRow][leftCol] = 1;
                        System.out.println(distance);
                        break;
                    }
                    // check right neighbour
                    if (rightCol < cols && parking[spotRow][rightCol] == 0) {
                        // The right spot is free and I can park there
                        distance += rightCol;
                        parking[spotRow][rightCol] = 1;
                        System.out.println(distance);
                        break;
                        }
                    count++;
                    }
                }
            input = scanner.nextLine();
        }
    }
}
