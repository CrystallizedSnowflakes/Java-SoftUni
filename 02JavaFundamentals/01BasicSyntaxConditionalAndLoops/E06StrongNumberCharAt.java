package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E06StrongNumberCharAt {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            //int digit = Integer.parseInt(String.valueOf(input.charAt(i)));
            int digit = input.charAt(i) - 48; // ASCII table char '0' = int 48
            // 48-48=0 starts from i=0 | 49-48=1 where i=1
            int factorial = 1;
            for (int j = 1; j <=digit; j++) {
                factorial *= j;
            }
            sum += factorial;
        }
        int wholeNum = Integer.parseInt(input);
        if (sum == wholeNum){
            System.out.print("yes");
        }else{
            System.out.print("no");
        }
    }
}
