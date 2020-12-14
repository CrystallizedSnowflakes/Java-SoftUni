package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME2PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] currentArray = { 1 };

        for (int i = 0; i < n; i++) {
            int[]nextArray  = new int[currentArray.length + 1];

            for (int j = 0; j < currentArray.length; j++) {
                nextArray[j] += currentArray[j];
                nextArray[j + 1] += currentArray[j];
                System.out.print(currentArray[j] + " ");
            }
            currentArray = nextArray;
            System.out.println();
        }
    }
}
