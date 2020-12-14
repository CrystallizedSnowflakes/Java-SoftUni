package bg.softuni.javafundamentals;

import java.util.*;
import java.util.stream.Collectors;

public class E08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        while (true){
            String[]tokens = scanner.nextLine().split(" ");
            if (tokens[0].equals("3:1")){
                break;
            }

            switch (tokens[0]){
                case "merge":
                    merge(input, tokens);
                    break;
                case "divide":
                    divide(input, tokens);
                    break;
            }
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void merge(List<String> input, String[] tokens) {
        int startIndex = Integer.parseInt(tokens[1]);
        if (startIndex < 0 || startIndex > input.size() - 1){
            startIndex = 0;
        }
        int endIndex = Integer.parseInt(tokens[2]);
        if (endIndex > input.size() - 1 || endIndex < 0) {
            endIndex = input.size() - 1;
        }

        for (int i = startIndex; i < endIndex; i++) {
            String currentStr = input.get(startIndex);
            String nextStr = input.get(startIndex + 1);

            String mergedStr = currentStr + nextStr;

            input.set(startIndex, mergedStr);
            input.remove(startIndex + 1);

        }
    }

    private static void divide(List<String> input, String[] tokens) {
        int index = Integer.parseInt(tokens[1]);
        int partitions = Integer.parseInt(tokens[2]);
        String element = input.get(index);

        if (partitions == 0 || element.length() < partitions){
            return;
        }

        int firstElementsSize = element.length() / partitions;
        String firstElement = "";
        int lastElementSize = firstElementsSize + element.length() % partitions;

        if (element.length() % partitions != 0){

            input.remove(index);
            int count = 0;
            for (int i = 0; i < partitions - 1; i ++) {
                for (int j = 0; j < firstElementsSize; j++) {
                    firstElement += element.charAt(count);
                    count++;
                }
                input.add(index + i, firstElement);
                firstElement = "";
            }
            for (int i = 0; i < lastElementSize; i++) {
                firstElement += element.charAt(count + i);
            }
            input.add(index + partitions - 1, firstElement);


        }else{ //(size % partitions == 0)
            input.remove(index);
            int count = 0;
            for (int i = 0; i < partitions; i ++) {
                for (int j = 0; j < firstElementsSize; j++) {
                    firstElement += element.charAt(count);
                    count++;
                }
                input.add(index + i, firstElement);
                firstElement = "";
            }
        }
    }
}
