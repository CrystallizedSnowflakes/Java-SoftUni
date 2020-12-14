package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME02FromLeftToRight2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split(" ");
            long leftNum = Long.parseLong(input[0]);
            long rightNum = Long.parseLong(input[1]);

            char firstCharAtZero = input[0].charAt(0);
            char firstCharAtOne = input[1].charAt(0);

            String positiveStringZero = "";
            if (firstCharAtZero == '-' ){
                for (int j = 1; j < input[0].length() ; j++) {
                    positiveStringZero += input[0].charAt(j);
                }
            }else{
                positiveStringZero = input[0];
            }

            String positiveStringOne = "";
            if (firstCharAtOne == '-'){
                for (int j = 1; j < input[1].length(); j++) {
                    positiveStringOne += input[1].charAt(j);
                }
            }else{
                positiveStringOne = input[1];
            }

            int leftSum = 0;
            for (int j = 0; j < positiveStringZero.length(); j++) {
                leftSum += positiveStringZero.charAt(j) - 48;
            }

            int rightSum = 0;
            for (int j = 0; j < positiveStringOne.length(); j++) {
                rightSum += positiveStringOne.charAt(j) - 48;
            }

            if (leftNum > rightNum){
                System.out.println(leftSum);
            }else{
                System.out.println(rightSum);
            }
        }
    }
}
