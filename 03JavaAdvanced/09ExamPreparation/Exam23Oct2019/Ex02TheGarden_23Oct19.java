package bg.softuni.javaadvanced;

import java.util.Scanner;

public class Ex02TheGarden_23Oct19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] garden = fillTheGardenWithVegetables(rows, scanner);

        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int countOfHarmedVegetables = 0;

        String line = scanner.nextLine();
        while (!line.equals("End of Harvest")){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (isOutOfBounds(garden, row, col)){
                line = scanner.nextLine();
                continue;
            }

            switch (command){
                case "Harvest":

                    char symbol = garden[row][col];
                    switch (symbol){
                        case 'C':
                            garden[row][col] = ' ';
                            carrots++;
                            break;
                        case 'P':
                            garden[row][col] = ' ';
                            potatoes++;
                            break;
                        case 'L':
                            garden[row][col] = ' ';
                            lettuce++;
                            break;
                        default:
                            break;
                    }
                    break;

                case "Mole":

                    String direction = tokens[3];
                    switch (direction){
                        case "up":
                            while (row >= 0){
                                if (garden[row][col] != ' '){
                                    countOfHarmedVegetables++;
                                }
                                garden[row][col] = ' ';
                                row -= 2;
                            }
                            break;
                        case "down":
                            while (row < garden.length){
                                if (garden[row][col] != ' '){
                                    countOfHarmedVegetables++;
                                }
                                garden[row][col] = ' ';
                                row += 2;
                            }
                            break;
                        case "left":
                            while (col > 0){
                                if (garden[row][col] != ' '){
                                    countOfHarmedVegetables++;
                                }
                                garden[row][col] = ' ';
                                col -= 2;
                            }
                            break;
                        case "right":
                            while (col < garden[row].length){
                                if (garden[row][col] != ' '){
                                    countOfHarmedVegetables++;
                                }
                                garden[row][col] = ' ';
                                col += 2;
                            }
                            break;
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        printGarden(garden);
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + countOfHarmedVegetables);
    }

    public static boolean isInBounds(char[][] garden, int row, int col){
        return row >= 0 && row < garden.length && col >= 0 && col < garden[row].length;
    }

    public static boolean isOutOfBounds(char[][] garden, int row, int col){
        return row < 0 || row >= garden.length || col < 0 || col >= garden[row].length;
    }

    private static void printGarden(char[][] garden) {
        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] fillTheGardenWithVegetables(int rows, Scanner scanner) {
        char[][] matrix = new char[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
