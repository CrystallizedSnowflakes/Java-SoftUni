package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true){
            String line = scanner.nextLine().toLowerCase();
            if (line.equals("end")){
                break;
            }
            String[]tokens = line.split(" ");
            switch (tokens[0]) {
                case "add":
                    addNumber(numbers, tokens[1]);
                    break;
                case "remove":
                    removeNumber(numbers, tokens[1]);
                    break;
                case "removeat":
                    removeAtIndex(numbers, tokens[1]);
                    break;
                case "insert":
                    insertAtIndexNumber(numbers, tokens);
                    break;
                case "contains":
                    printIfContainsNumber(numbers, tokens[1]);
                    break;
                case "print":
                    printEvenOrOddNumbers(numbers, tokens[1]);
                    break;
                case "get":
                    sum(numbers, tokens[1]);
                    break;
                case "filter":
                    filterNumbersByCondition(numbers, tokens);
                    break;
            }
        }
    }

    private static void filterNumbersByCondition(List<Integer> numbers, String[] tokens) {
        String condition = tokens[1];
        int numberToCompare = Integer.parseInt(tokens[2]);
        switch (condition){
            case "<":
                for (Integer number : numbers) {
                    if (number < numberToCompare){
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case ">":
                for (Integer number : numbers) {
                    if (number > numberToCompare){
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case ">=":
                for (Integer number : numbers) {
                    if (number >= numberToCompare){
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case "<=":
                for (Integer number : numbers) {
                    if (number <= numberToCompare){
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
        }
    }

    private static void sum(List<Integer> numbers, String token) {
        String action = token;
        if (action.equals("sum")){
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            System.out.println(sum );
        }
    }

    private static void printEvenOrOddNumbers(List<Integer> numbers, String token) {
        String type = token;
        if (type.equals("even")){
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 == 0){
                    System.out.print(numbers.get(i) + " ");
                }
            }
            System.out.println();
        }
        if (type.equals("odd")){
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 != 0){
                    System.out.print(numbers.get(i) + " ");
                }
            }
            System.out.println();
        }
    }

    private static void printIfContainsNumber(List<Integer> numbers, String token) {
        int numberToContains = Integer.parseInt(token);
        if (numbers.contains(numberToContains)){
            System.out.println("Yes");
        }else{
            System.out.println("No such number");
        }
    }

    private static void insertAtIndexNumber(List<Integer> numbers, String[] tokens) {
        int numberToInsert = Integer.parseInt(tokens[1]);
        int indexToInsert = Integer.parseInt(tokens[2]);
        numbers.add(indexToInsert, numberToInsert);
    }

    private static void removeAtIndex(List<Integer> numbers, String token) {
        int indexToRemove = Integer.parseInt(token);
        numbers.remove(indexToRemove);
    }

    private static void removeNumber(List<Integer> numbers, String token) {
        int numberToRemove = Integer.parseInt(token);
        numbers.remove((Integer)numberToRemove);
        //numbers.remove(Integer.valueOf(numberToRemove));
    }

    private static void addNumber(List<Integer> numbers, String token) {
        int numberToAdd = Integer.parseInt(token);
        numbers.add(numberToAdd);
    }
}
