package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ExMagicNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        char firstChar = first.charAt(0);
        String second = scanner.nextLine();
        char secondChar = second.charAt(0);
        String third = scanner.nextLine();
        char toAvoid = third.charAt(0);

        for (char i = firstChar; i <= secondChar; i++) {
            for (char j = firstChar; j <= secondChar; j++){
                for (char k = firstChar; k <= secondChar ; k++) {
                    if (i != toAvoid && j != toAvoid && k != toAvoid){
                        System.out.printf("%s%s%s ", i, j, k);
                    }
                }
            }
            
        }
        //a
        //c
        //b
        // aaa aac aca acc caa cac cca ccc
    }
}
