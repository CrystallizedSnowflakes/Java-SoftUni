package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class A03SumEvenNumbers { // четно
    public static void main(String[] args) {
        int[] numbers = Arrays
                .stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0)
            sum+=numbers[i];
        }
        System.out.print(sum);
    }
}
