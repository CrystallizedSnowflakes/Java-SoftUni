package bg.softuni.javabasics;

import java.util.Scanner;

public class A10InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int realNumber = Integer.parseInt(scanner.nextLine());
        boolean isValid = (100 <= realNumber && realNumber <= 200) || realNumber == 0;

        if (!(isValid)){
            System.out.println("invalid");
        }
    }
}
