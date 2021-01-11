package bg.softuni.javaadvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01ReverseNumbersWithAStack2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stackOfNumbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(stackOfNumbers::push);

        System.out.print(String.join(" ", stackOfNumbers));
    }
}
