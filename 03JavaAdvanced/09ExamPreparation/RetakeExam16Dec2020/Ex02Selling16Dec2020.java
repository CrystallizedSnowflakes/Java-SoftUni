package bg.softuni.javaadvanced;

import java.util.Scanner;

public class Ex02Selling16Dec2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] bakery = scanBakery(scanner, size);
        int[] seller = locateSeller(bakery);
        int row = seller[0];
        int col = seller[1];

        int money = 0;
        while (money < 50){
            bakery[row][col] = '-';
            String command = scanner.nextLine();
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
                default:
                    break;
            }
            if (!iAmInTheBakery(row, col, bakery)) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
            char symbol = bakery[row][col];
            if (Character.isDigit(symbol)){
                money += Integer.parseInt(String.valueOf(symbol));
            } else if (symbol == 'O'){
                bakery[row][col] = '-';
                sellerGoesOutOnPillar(bakery, seller);
                row = seller[0];
                col = seller[1];
            }
            bakery[row][col] = 'S';
        }

        if (money >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);
        printBakery(bakery);
    }

    private static void sellerGoesOutOnPillar(char[][] bakery, int[]seller) {
        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                if (bakery[row][col] == 'O'){
                    seller[0] = row;
                    seller[1] = col;
                }
            }
        }
    }

    private static void printBakery(char[][] bakery) {
        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                System.out.print(bakery[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean iAmInTheBakery(int row, int col, char[][]bakery){
        return row >= 0 && row < bakery.length && col >= 0 && col < bakery[row].length;
    }

    private static int[] locateSeller(char[][] bakery) {
        int[] seller = new int[2];
        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                if (bakery[row][col] == 'S'){
                    seller[0] = row;
                    seller[1] = col;
                }
            }
        }
        return seller;
    }

    private static char[][] scanBakery(Scanner scanner, int size) {
        char[][]matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
