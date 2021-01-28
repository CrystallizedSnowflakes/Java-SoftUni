package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E08CustomComparator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.comparingInt((Integer f) -> Math.abs(f % 2)).thenComparingInt(f -> f))
                .map(e -> e + " ")
                .forEach(System.out::print);

/*        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)

                .sorted((f, s) ->{
                    int result = Integer.compare(Math.abs(f % 2), Math.abs(s % 2));
                    if (result == 0){
                        result = f - s;
                    }
                    return result;
                })

                .map(e -> e + " ")
                .forEach(System.out::println);*/


    }
}
