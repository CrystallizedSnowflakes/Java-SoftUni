package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E10LadyBugs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] field = new int[fieldSize];

        int[] indexesOfLadybug = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < indexesOfLadybug.length; i++) {
            int index = indexesOfLadybug[i];
            if (0 <= index && index < fieldSize){
                field[index] = 1;
            }
        }

        String input = scanner.nextLine().toLowerCase();
        while (!input.equals("end")){
            String[] commands = input.split(" ");
            int index = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int lengthOfFlight = Integer.parseInt(commands[2]);

            if (0 <= index && index < fieldSize && field[index] == 1){
                field[index] = 0;
            }else{
                input = scanner.nextLine().toLowerCase();
                continue;
            }
//            if (index < 0 || index >= field.length || field[index] == 0){ // !=1 means NO ladybug = EMPTY
//                input = scanner.nextLine().toLowerCase();
//                continue; // don't execute the code below, just goes to the beginning of the loop()
//            }
//            field[index] = 0;

            if (direction.equals("right")){
                index += lengthOfFlight;
                while (0 <= index && index < fieldSize && field[index] == 1) {
                    index += lengthOfFlight;
                }
                if (0 <= index && index < fieldSize) {
                    field[index] = 1;
                }
            }else{
                index -= lengthOfFlight;
                while (0 <= index && index < fieldSize && field[index] == 1){
                        index -= lengthOfFlight;
                    }
                if (0 <= index && index < fieldSize){
                    field[index] = 1;
                }
            }
            input = scanner.nextLine().toLowerCase();
        }
        for (int j : field) {
            System.out.print(j + " ");
        }
    }
}
