package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int leftSum = 0;
        int rightSum = 0;
        int index = -1;
        if (inputArr.length == 1){
            System.out.print(0);
        }else{
            for (int i = 0; i < inputArr.length; i++) {
                if (i != 0) {
                    leftSum += inputArr[i - 1];
                }
                for (int j = i + 1; j < inputArr.length; j++) {
                    rightSum += inputArr[j];
                }
                if (leftSum == rightSum){
                    index = i;
                }
                rightSum = 0;
            }
            if (index != -1){
                System.out.println(index);
            }else{
                System.out.println("no");
            }
        }
    }
}
