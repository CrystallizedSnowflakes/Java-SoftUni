package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A01FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(", ");

        String output = Arrays.stream(strings)
                .mapToInt(e -> Integer.parseInt(e))
                .filter(num -> num % 2 == 0)
                .mapToObj(e -> String.valueOf(e))
                .collect(Collectors.joining(", "));

        System.out.println(output);

        output = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0) // return boolean
                .sorted()
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);
    }
}
