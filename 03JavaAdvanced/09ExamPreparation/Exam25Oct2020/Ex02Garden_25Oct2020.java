package bg.softuni.javaadvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex02Garden_25Oct2020 {
    private static List<int[]> flowers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();

        int[][] garden = prepareTheGarden(r, c);
        String input = scanner.nextLine();
        while (!input.equals("Bloom Bloom Plow")){
            int[] dimensions = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = dimensions[0];
            int col = dimensions[1];
            if (isOutOfTheGarden(row, col, garden)){
                System.out.println("Invalid coordinates.");
                input = scanner.nextLine();
                continue;
            } else {
                int[] flower = new int[2];
                flower[0] = row;
                flower[1] = col;
                flowers.add(flower);
                garden[row][col] = 1;
            }
            input = scanner.nextLine();
        }

        bloom(garden);
        showTheBeautyOfTheGarden(garden);
    }

    private static void bloom(int[][] garden) {

        for (int[] flower : flowers) {
            int r = flower[0];
            int c = flower[1];

            // up
            int row = r - 1;
            int col = c;
            while (row >= 0){
                garden[row--][col] += 1;
            }
            // down
            row = r + 1;
            while (row < garden.length){
                garden[row++][col] += 1;
            }
            // left
            row = r;
            col = c - 1;
            while (col >= 0){
                garden[row][col--] += 1;
            }
            // right
            col = c + 1;
            while (col < garden[row].length){
                garden[row][col++] += 1;
            }
        }
    }

    private static boolean isInTheGarden(int row,int col, int[][] garden){
        return row >= 0 && row < garden.length && col >= 0 && col < garden[row].length;
    }

    private static boolean isOutOfTheGarden(int row,int col, int[][] garden){
        return row < 0 || row >= garden.length || col < 0 || col >= garden[row].length;
    }

    private static void showTheBeautyOfTheGarden(int[][] garden){
        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] prepareTheGarden(int r, int c) {
        int[][] garden = new int[r][c];
        for (int row = 0; row < garden.length; row++) {
            Arrays.fill(garden[row], 0);
        }
        return garden;
    }
}
