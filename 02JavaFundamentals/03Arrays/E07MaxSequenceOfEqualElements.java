package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E07MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        String[] inputArr = new Scanner(System.in).nextLine().split(" ");

        int currentCount = 1;
        int maxCount = 0;
        String element = "";

        for (int i = 0; i < inputArr.length - 1; i++) {

            if (inputArr[i].equals(inputArr[i + 1])) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    element = inputArr[i];
                }
            } else {
                currentCount = 1;
            }
        }
        String[] output = new String[maxCount];
        Arrays.fill(output, element);
        System.out.print(String.join(" ", output));
    }
}
