package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class A05Largest3Numbers2 {
    public static void main(String[] args) {
        // input 10 30 15 20 50 5
        // output 50 30 20
/*        int[] numbers = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .sorted()
                .limit(3)
                .toArray();*/
        // 5 10 15

/*        List<Integer> filtered = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(3)
                .collect(Collectors.toList());

        for (Integer integer : filtered) {
            System.out.print(integer + " ");
        }*/

        Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(3)
                .forEach(i -> System.out.print(i + " "));

    }
}
