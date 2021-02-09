package bg.softuni.javaadvanced;

import java.util.Scanner;

public class Ex02PresentDelivery_17Dec19 {
    static int countOfPresents;
    static boolean notRunOut = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        countOfPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] neighborhood = scanMatrix(scanner, size);
        int[] santa = findSanta(neighborhood);
        int countOfNiceKids = countNiceKids(neighborhood);
        int row = santa[0];
        int col = santa[1];

        String command = scanner.nextLine();
        while (countOfPresents > 0 && !command.equals("Christmas morning")){
            neighborhood[row][col] = '-';
            switch (command){
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }

            if (!isInBounds(row, col, neighborhood)){
                break;
            }

            char symbol = neighborhood[row][col];
            switch (symbol){
                case 'V':
                    neighborhood[row][col] = 'S';
                    countOfPresents--;
                    break;
                case 'C':
                    neighborhood[row][col] = 'S';
                    happySantaGivesPresentsToAllKids(row, col, neighborhood);
                    break;
                default:
                    neighborhood[row][col] = 'S';
                    break;
            }
            if (countOfPresents == 0){
                break;
            }
            command = scanner.nextLine();
        }

        if (countOfPresents == 0 && !notRunOut){
            System.out.println("Santa ran out of presents!");
        }

        printNeighborhood(neighborhood);

        int countOfRestNiceKidsIfAny = countNiceKids(neighborhood);
        if (countOfRestNiceKidsIfAny == 0){
            System.out.println("Good job, Santa! " + countOfNiceKids + " happy nice kid/s.");
        } else {
            System.out.println("No presents for " + countOfRestNiceKidsIfAny + " nice kid/s.");
        }
    }

    private static int countNiceKids(char[][] neighborhood) {
        int countOfNiceKids = 0;
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                if (neighborhood[row][col] == 'V'){
                    countOfNiceKids++;
                }
            }
        }
        return countOfNiceKids;
    }

    private static void happySantaGivesPresentsToAllKids(int r, int c, char[][] neighborhood) {
        // up
        int row = r - 1;
        int col = c;
        givePresents(neighborhood, row, col);
        // down
        row = r + 1;
        givePresents(neighborhood, row, col);
        // left
        row = r;
        col = c - 1;
        givePresents(neighborhood, row, col);
        // right
        col = c + 1;
        givePresents(neighborhood, row, col);

        int countOfRestNiceKidsIfAny = countNiceKids(neighborhood);
        if (countOfRestNiceKidsIfAny == 0 && countOfPresents == 0) {
            notRunOut = true;
        }
    }

    private static void givePresents(char[][] neighborhood, int row, int col) {
        if (isInBounds(row, col, neighborhood)) {
            if (countOfPresents > 0 && (neighborhood[row][col] == 'V' || neighborhood[row][col] == 'X')) {
                neighborhood[row][col] = '-';
                countOfPresents--;
            }
        }
    }

    private static boolean isInBounds(int row, int col, char[][] neighborhood) {
        return row >= 0 && row < neighborhood.length && col >= 0 && col < neighborhood[row].length;
    }

    private static int[] findSanta(char[][] neighborhood) {
        int[] santa = new int[2];
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                if (neighborhood[row][col] == 'S'){
                    santa[0] = row;
                    santa[1] = col;
                }
            }
        }
        return santa;
    }

    private static void printNeighborhood(char[][] neighborhood) {
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                System.out.print(neighborhood[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] scanMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
