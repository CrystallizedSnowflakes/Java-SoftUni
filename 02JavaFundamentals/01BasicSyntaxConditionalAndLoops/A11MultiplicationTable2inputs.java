package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A11MultiplicationTable2inputs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int multiplier = scanner.nextInt();
        int i = multiplier;
        if (i <= 10){
            for (i = multiplier; i <= 10; i++){
                System.out.printf("%d X %d = %d%n", num, i, num * i);
            }
        }else{
            System.out.printf("%d X %d = %d%n", num, i, num * i);
        }
    }
}
