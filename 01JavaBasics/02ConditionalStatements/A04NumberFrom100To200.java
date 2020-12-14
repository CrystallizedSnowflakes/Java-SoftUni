package bg.softuni.javabasics;

import java.util.Scanner;

public class A04NumberFrom100To200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        if (number < 100){
            System.out.println("Less than 100");
        //}else if(100 <= number && number <= 200){
        }else if(number <= 200){
            System.out.println("Between 100 and 200");
        }else{
            System.out.println("Greater than 200");
        }
    }
}
