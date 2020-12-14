package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int n = scanner.nextInt();

        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if ((inputArr[i] + inputArr[j]) == n){
                    System.out.printf("%d %d%n", inputArr[i], inputArr[j]);
                }
            }
        }
    }
}
