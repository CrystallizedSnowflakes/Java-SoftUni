package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A05Largest3Numbers {
    public static void main(String[] args) {
        Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((x1, x2) -> x2.compareTo(x1))
                .limit(3)
                .collect(Collectors.toList())
                .forEach(w -> System.out.print(w + " "));
    }
}
