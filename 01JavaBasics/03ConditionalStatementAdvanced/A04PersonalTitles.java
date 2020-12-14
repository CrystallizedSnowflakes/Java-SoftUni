package bg.softuni.javabasics;

import java.util.Scanner;

public class A04PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        char gender = input.charAt(0);

        switch (gender){
            case 'm':
                if (age >= 16){
                    System.out.println("Mr.");
                }else{
                    System.out.println("Master");
                }
                break;
            case 'f':
                if (age >= 16){
                    System.out.println("Ms.");
                }else{
                    System.out.println("Miss");
                }
                break;
        }
    }
}
