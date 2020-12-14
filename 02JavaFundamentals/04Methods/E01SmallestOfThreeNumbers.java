package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        //printSmallestOfThreeIntegers(a,b,c);
        int smallerNumber = findSmallerNumber(first, second);
        int theSmallestNumber = findSmallerNumber(smallerNumber, third);

        System.out.println(theSmallestNumber);

    }

    private static int findSmallerNumber(int a, int b){
        if (a < b){
            return a;
        }
        return b;
    }

//    private static void printSmallestOfThreeIntegers(int firstNumber, int secondNumber, int thirdNumber) {
//        if (firstNumber < secondNumber){
//            if (firstNumber < thirdNumber){
//                System.out.println(firstNumber);
//            }else{
//                System.out.println(thirdNumber);
//            }
//        }else{
//            if (secondNumber < thirdNumber){
//                System.out.println(secondNumber);
//            }else{
//                System.out.println(thirdNumber);
//            }
//        }
//    }
}
