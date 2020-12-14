package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();

        if (firstNum < secondNum) {
            int temp1 = firstNum;
            firstNum = secondNum;
            secondNum = temp1;
        }
        if (secondNum < thirdNum){
            int temp2 = secondNum;
            secondNum = thirdNum;
            thirdNum = temp2;
        }
        if (firstNum < secondNum){
            int temp3 = firstNum;
            firstNum = secondNum;
            secondNum = temp3;
        }

        System.out.println(firstNum);
        System.out.println(secondNum);
        System.out.println(thirdNum);
    }
}
