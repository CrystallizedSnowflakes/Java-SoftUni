package bg.softuni.javafundamentals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A01SumAdjacentEqualNumbersDecimalFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        List<Double> numbers = Arrays
//                .stream(scanner.nextLine().split(" "))
//                .map(Double :: parseDouble)
//                .collect(Collectors.toList());
        List<Double> numbers = parseLineAsRealNumbers(scanner);

        int i = 0;
        while (i < numbers.size() - 1){
            double current = numbers.get(i);
            double next = numbers.get(i + 1);
            if (current == next){
                numbers.remove(i);
                numbers.set(i, current + next);
                i = 0;
            }else{
                i++;
            }
        }

//        printRealAsStringBySpace(numbers);

        String output = joinElementsByDelimiter(numbers, " ");
        System.out.println(output);
//        for (Double number : numbers) {
//            System.out.print(number + " ");
//        }
    }

    private static void printRealAsStringBySpace(List<Double> numbers) {
        String[] numbersAsString = new String[numbers.size()];
        for (int j = 0; j < numbers.size(); j++) {
            numbersAsString[j] = new DecimalFormat(("0.#")).format(numbers.get(j));
        }
        System.out.println(String.join(" ",numbersAsString));
    }

    private static List<Double> parseLineAsRealNumbers(Scanner scanner) {
        String line = scanner.nextLine();
        String[]numbersAsStrings = line.split(" ");
        List<Double> numbers = new ArrayList<>();
        for(String s : numbersAsStrings) {
            double number = Double.parseDouble(s);
            numbers.add(number);
        }
        return numbers;
    }

    private static String joinElementsByDelimiter(List<Double>items, String delimiter){
        String output = "";
        for (Double item : items) {
            output += (new DecimalFormat(("0.#")).format(item) + delimiter);
        }
        return output;
    }
}
