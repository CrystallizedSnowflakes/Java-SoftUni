package bg.softuni.javaadvanced;

import java.util.Scanner;
import java.util.function.Function;

public class A02SumNumbersFunction2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        if (input.length < 2){
            System.out.println("Count = " + input.length);
            System.out.println("Sum = " + input[0]);
        } else {
            Function<String, Integer> parser = x -> Integer.parseInt(x);
            int sum = 0;
            for (String s : input) {
                sum += parser.apply(s);
            }
            System.out.println("Count = " + input.length);
            System.out.println("Sum = " + sum);
        }
    }
}
