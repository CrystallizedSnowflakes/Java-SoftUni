package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A02PrintNumbersInReverseOrderSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < numbers.length / 2; i++) {
            int swapIndex = numbers.length - 1 - i;
            int oldNumbersI = numbers[i];
            numbers[i] = numbers[swapIndex];
            numbers[swapIndex] = oldNumbersI;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
//        for (int i = numbers.length - 1; i >= 0 ; i--) {
//            System.out.print(numbers[i] + " ");
//        }
    }
}
