package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] firstArr = new String[n];
        String[] secondArr = new String[n];

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");

            if (i % 2 == 0){
                firstArr[i] = inputArr[0];
                secondArr[i] = inputArr[1];
            }else{
                firstArr[i] = inputArr[1];
                secondArr[i] = inputArr[0];
            }
        }

        System.out.printf("%s%n", String.join(" ", firstArr));
        System.out.printf("%s%n", String.join(" ", secondArr));
    }
}
