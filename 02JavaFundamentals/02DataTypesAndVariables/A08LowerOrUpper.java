package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A08LowerOrUpper {
    public static void main(String[] args) {

        String letter = new Scanner(System.in).nextLine();
        int letterRepresentationInAsciiTableAsNumber = letter.charAt(0);

        if(65 <= letterRepresentationInAsciiTableAsNumber && letterRepresentationInAsciiTableAsNumber <= 90)
            System.out.println("upper-case");
        if(97 <= letterRepresentationInAsciiTableAsNumber && letterRepresentationInAsciiTableAsNumber <= 122)
            System.out.println("lower-case");
    }
}
