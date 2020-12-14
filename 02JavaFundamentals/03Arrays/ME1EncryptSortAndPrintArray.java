package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class ME1EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            int sum = 0;
            for (int j = 0; j < input.length(); j++) {
                switch (input.charAt(j)){
                    case 'a':
                    case 'A':
                    case 'e':
                    case 'E':
                    case 'i':
                    case 'I':
                    case 'o':
                    case 'O':
                    case 'u':
                    case 'U':
                        sum += input.charAt(j) * input.length();
                        break;
                    default:
                        sum += input.charAt(j) / input.length();
                        break;
                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
