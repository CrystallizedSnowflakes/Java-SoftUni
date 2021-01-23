package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class A04CountRealNumbersStreamMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble) // Stream<Double>
                .forEach(n -> {
                    numbers.putIfAbsent(n, 0);
                    numbers.put(n, numbers.get(n) + 1);
                });

        numbers.entrySet()
                .stream()
                .map(entry -> String.format("%.1f -> %d",entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }
}
