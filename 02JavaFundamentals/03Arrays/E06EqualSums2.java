package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E06EqualSums2 {
    public static void main(String[] args) {
        int[] numbers = Arrays
                .stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        if (numbers.length < 1){
            System.out.println(0);
            return; // stop the rest of the program below
        }
        boolean isEqual = false;
        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            // left sum for loop
            for (int j = i - 1; j >= 0 ; j--) {
                leftSum += numbers[j];
            }
            // right sum for loop
            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }
            if (leftSum == rightSum){
                isEqual = true;
                System.out.print(i);
                break;
            }
        }
        if (!isEqual){
            System.out.println("no");
        }
    }
}
