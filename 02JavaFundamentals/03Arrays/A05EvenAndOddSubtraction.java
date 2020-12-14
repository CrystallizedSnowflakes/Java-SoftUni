package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class A05EvenAndOddSubtraction {
    public static void main(String[] args) {
        int[] numbers = Arrays
                .stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int evenSum = 0;
        int oddSum = 0;
        int subtractionOfEvenAndOdd = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0){
                evenSum += numbers[i];
            }else{
                oddSum += numbers[i];
            }
        }
        subtractionOfEvenAndOdd = evenSum - oddSum;
        System.out.println(subtractionOfEvenAndOdd);
    }
}
