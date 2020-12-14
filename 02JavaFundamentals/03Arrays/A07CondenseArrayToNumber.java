package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class A07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[]nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int length = nums.length;
        int sum = nums[0];
        while(length > 1){
            int[]condensed = new int[nums.length - 1];
            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = nums[i] + nums[i + 1];
            }
            nums = condensed;
            sum = condensed[0];
            length--;
        }
        System.out.println(sum);
    }
}
