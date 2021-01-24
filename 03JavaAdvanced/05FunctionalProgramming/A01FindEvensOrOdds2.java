package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A01FindEvensOrOdds2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(", ");

        List<Integer> numbers = Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //numbers.removeIf(e -> e % 2 != 0);
        numbers.removeIf(A01FindEvensOrOdds2::isNumberOdd);

        String output1 = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output1);

        numbers.sort((f, s) -> f.compareTo(s));

        String output2 = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output2);
    }

    public static boolean isNumberOdd(int number){
        return  number % 2 != 0;
    }
}
