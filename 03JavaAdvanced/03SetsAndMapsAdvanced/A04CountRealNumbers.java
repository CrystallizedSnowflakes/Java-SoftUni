package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Map

        double[] realNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> realNumbersAndItsOccurrences = new LinkedHashMap<>();

        for (double realNumber : realNumbers) {

            if (!realNumbersAndItsOccurrences.containsKey(realNumber)) {
                realNumbersAndItsOccurrences.put(realNumber, 1);
            } else {
                Integer currentRealNumber = realNumbersAndItsOccurrences.get(realNumber);
                realNumbersAndItsOccurrences.put(realNumber, currentRealNumber + 1);
            }
        }

        for (Double key : realNumbersAndItsOccurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", key, realNumbersAndItsOccurrences.get(key));
        }
    }
}
