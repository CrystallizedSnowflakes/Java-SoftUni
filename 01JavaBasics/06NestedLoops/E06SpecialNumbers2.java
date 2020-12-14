package bg.softuni.javabasics;

import java.util.Scanner;

public class E06SpecialNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        // 1111 to 9999
        for (int i = 1111; i <= 9999 ; i++) {
            // print special numbers
            int number = i;
            int count = 0;
            while (number > 0){
                int lastDigit = number % 10;
                if (lastDigit != 0 && n % lastDigit == 0){
                    count++;
                }else{
                    break;
                }
                number = number / 10;
            }
            if (count == 4){
                System.out.print(i + " ");
            }
        }
    }
}
