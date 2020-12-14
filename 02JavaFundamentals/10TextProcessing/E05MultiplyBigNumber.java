package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine().replaceFirst("^0+", "");
        int second = Integer.parseInt(scanner.nextLine());

        if (second == 0){
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();

        int remainder = 0;
        for (int i = first.length() - 1; i >= 0 ; i--) {
            int digit = Integer.parseInt(String.valueOf(first.charAt(i)));
            int result = digit * second + remainder;

            if (i == 0){ // first position at the end of the loop
                sb.insert(0, result);
            } else {
                int lastDigit = result % 10;
                remainder = result / 10;

                sb.insert(0, lastDigit); //insert on first position
            }
        }
        System.out.println(sb);
    }
}
