package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        // filter
        Predicate<String> hasSameLength = name -> name.length() <= length;

        Arrays.stream(names).filter(hasSameLength).forEach(System.out::println);
    }
}
