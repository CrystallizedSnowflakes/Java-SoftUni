package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class A06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]firstArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int[]secondArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        boolean areEqual = true;
        if (firstArray.length != secondArray.length){
            areEqual = false;
        }
        int sumOfFirstArray = 0;
        int index = 0;

        for (int i = 0; i < firstArray.length; i++) {
            sumOfFirstArray += firstArray[i];
            if (firstArray[i] != secondArray[i]){
                areEqual = false;
                index = i;
                break;
            }
        }
        if (areEqual){
            System.out.printf("Arrays are identical. Sum: %d", sumOfFirstArray);
        }else{
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }
    }
}
