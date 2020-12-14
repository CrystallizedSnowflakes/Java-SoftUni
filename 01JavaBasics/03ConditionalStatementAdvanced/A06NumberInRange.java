package bg.softuni.javabasics;

import java.util.Scanner;

public class A06NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if((-100 <= number && number <= 100) && number != 0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
