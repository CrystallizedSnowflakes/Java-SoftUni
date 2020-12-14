package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A09SumOfOddNumbers {
    public static void main(String[] args) {

        int count = new Scanner(System.in).nextInt();
        int printedCount = 0;
        int num = 0;
        int sum = 0;
        while(printedCount < count){ //не знам колко на брой изпълнения ще имаме в програмата
            num++;
            if (num % 2 != 0){ //нечетно            case: (-13 % 2 != 0) returns 1 => true
                System.out.println(num); //         case: (-13 % 2 == 1) returns -1 => false ! DO NOT use !
                printedCount++;
                sum += num;
            }
        }
//        int countOddNums = new Scanner(System.in).nextInt();
//        int sum = 0;
//        for (int i = 0; i < countOddNums*2; i++){
//            if (i % 2 != 0){
//                System.out.println(i);
//                sum += i;
//            }
//        }
//
        System.out.printf("Sum: %d", sum);
    }
}
