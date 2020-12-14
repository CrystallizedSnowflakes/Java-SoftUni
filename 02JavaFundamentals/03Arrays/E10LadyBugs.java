package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E10LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] field = new int[n];
        String[] bugIndexes = scanner.nextLine().split(" ");

        for (int i = 0; i < bugIndexes.length; i++) {
            int ladyBug = Integer.parseInt(bugIndexes[i]);
            if (ladyBug >= 0 && ladyBug < field.length) {
                field[ladyBug] = 1; // set the ladybugs
            }
        }

        String inputCommands = scanner.nextLine().toLowerCase();
        while(!inputCommands.equals("end")){
            String[] commands = inputCommands.split(" ");

            int bugIndex = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int flyLength = Integer.parseInt(commands[2]);

            if (bugIndex < 0 || bugIndex >= field.length || field[bugIndex] == 0){ // !=1 means NO ladybug = EMPTY
                inputCommands = scanner.nextLine().toLowerCase();
                continue; // don't execute the code below, just goes to the beginning of the loop()
            }

            field[bugIndex] = 0; // when we start the existing ladybug goes away so from 1 set to 0
            if (direction.equals("right")){
                bugIndex += flyLength; // first jump
                // flight
                while (bugIndex < field.length && field[bugIndex] == 1){ // jump a ladybug if any = 1
                    bugIndex += flyLength; // continue jumping if has 1
                }
                if (bugIndex < field.length){ // if the ladybug is in the field land off and set the index = 1
                    field[bugIndex] = 1;
                }
            }else{
                bugIndex -= flyLength; // first jump
                // flight
                while (bugIndex >= 0 && field[bugIndex] == 1){
                    bugIndex -= flyLength; // continue jumping if has 1
                }
                if (bugIndex >= 0){
                    field[bugIndex] = 1;
                }
            }
            inputCommands = scanner.nextLine().toLowerCase();
        }
        for (int j : field) {
            System.out.print(j + " ");
        }
    }
}
