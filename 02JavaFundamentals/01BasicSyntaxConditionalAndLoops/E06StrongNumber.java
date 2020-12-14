package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E06StrongNumber {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int wholeNum = Integer.parseInt(input);
        String[] strArr = input.split("");
        int[] nums = new int[strArr.length];
        for (int i = 0; i<nums.length; i++){
            nums[i] = Integer.parseInt(strArr[i]);
        }
        int finalSum = 0;
        for (int i = 0; i < nums.length; i++){
            int stop = nums[i];
            int factorial = 1;
            for (int j = 1; j <=stop; j++){
                factorial = factorial * j;
            }
            finalSum += factorial;
        }
        if (finalSum == wholeNum){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
