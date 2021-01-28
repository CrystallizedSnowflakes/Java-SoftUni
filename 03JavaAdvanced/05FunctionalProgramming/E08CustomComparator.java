package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // if  (a > b) returns  1
        // if  (b > a) returns -1
        // is (a == b) returns  0
        Comparator<Integer> comparator = ((f, s) -> {
                // even even
            if (f % 2 == 0 && s % 2 == 0){
                return f.compareTo(s); // compare by value in ascending order
                // even odd
            } else if (f % 2 == 0 && s % 2 != 0){
                return -1; // keep the same order even-odd
                // odd even
            } else if (f % 2 != 0 && s % 2 == 0){
                return 1; // reverse them to be even-odd
            }
                // odd odd
            return f.compareTo(s); // compare by value in ascending order
        });

        numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
