package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A04WordFilter {
    public static void main(String[] args) {

        Arrays
            .stream(new Scanner(System.in).nextLine().split("\\s+"))
            .filter(w -> w.length() % 2 == 0)
            .collect(Collectors.toList())
            .forEach(w -> System.out.println(w));

    }
}
