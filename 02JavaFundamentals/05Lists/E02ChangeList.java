package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true){
            String[]tokens = scanner.nextLine().toLowerCase().split("\\s+");
            if (tokens[0].equals("end")){
                break;
            }
            switch (tokens[0]){
                case "delete":
                    deleteIfEqual(numbers, tokens[1]);
                    break;
                case "insert":
                    insert(numbers, tokens);
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        //numbers.forEach(e -> System.out.print(e + " "));
    }

    private static void insert(List<Integer> numbers, String[] tokens) {
        int element = Integer.parseInt(tokens[1]);
        int position = Integer.parseInt(tokens[2]);
        if (position < numbers.size()){
            numbers.add(position, element);
        }
    }

    private static void deleteIfEqual(List<Integer> numbers, String token) {
        int givenElement = Integer.parseInt(token);
//        while (numbers.contains(givenElement)){
//            numbers.remove(Integer.valueOf(givenElement));
//        }
        int i = 0;
        while (i < numbers.size()){
            int currentNumber = numbers.get(i);
            if (currentNumber == givenElement){
                numbers.remove((Integer)currentNumber);
            }else{
                i++;
            }
        }
    }
}
