package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < inputArr.length; i++)
        {
            boolean isBigger = true;
            for (int j = i + 1; j < inputArr.length; j++)
            {
                if (inputArr[i] <= inputArr[j])
                {
                    isBigger = false;
                }
            }

            if (isBigger)
            {
                System.out.print(inputArr[i] + " ");
            }
        }
    }
}
