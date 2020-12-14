package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true){
            String[]commands = scanner.nextLine().split("\\s+");
            if (commands[0].equals("End")){
                break;
            }
            switch (commands[0]){
                case "Add":
                    addElement(numbers, commands[1]);
                    break;
                case "Insert":
                    insertAtIndexElement(numbers, commands);
                    break;
                case "Remove":
                    removeFromIndex(numbers, commands[1]);
                    break;
                case "Shift":
                    shiftLeftOrRight(numbers, commands);
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void shiftLeftOrRight(List<Integer> numbers, String[] commands) {
        String direction = commands[1];
        int count = Integer.parseInt(commands[2]);
        switch (direction){
            case "left":
                while (count != 0){
                    numbers.add(numbers.get(0));
                    numbers.remove(0);
                    count--;
                }
                break;
            case "right":
                while (count != 0){
                    numbers.add(0, numbers.get(numbers.size() - 1));
                    numbers.remove(numbers.size() - 1);
                    count--;
                }
                break;
        }
    }

    private static void removeFromIndex(List<Integer> numbers, String command) {
        int indexToRemove = Integer.parseInt(command);
        if (indexToRemove < 0 || indexToRemove > numbers.size()){
            System.out.println("Invalid index");
        }else{
            numbers.remove(indexToRemove);
        }
    }

    private static void insertAtIndexElement(List<Integer> numbers, String[] commands) {
        int number = Integer.parseInt(commands[1]);
        int indexToInsert = Integer.parseInt(commands[2]);
        if (indexToInsert < 0 || indexToInsert > numbers.size()){
            System.out.println("Invalid index");
        }else{
            numbers.add(indexToInsert, number);
        }
    }

    private static void addElement(List<Integer> numbers, String command) {
        int numberToAdd = Integer.parseInt(command);
        numbers.add(numberToAdd);
    }
}
