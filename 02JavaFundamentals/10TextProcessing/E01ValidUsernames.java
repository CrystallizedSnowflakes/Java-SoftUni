package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E01ValidUsernames {
    public static void main(String[] args) {
        String[] userNames = new Scanner(System.in).nextLine().split(", ");


        for (int i = 0; i < userNames.length; i++) {
            boolean isValid = false;
            String name = userNames[i];
            if (name.length() >= 3 && name.length() <= 16){
                isValid = true;
                for (int j = 0; j < name.length(); j++) {
                    char symbol = name.charAt(j);
                    if (Character.isLetter(symbol) || Character.isDigit(symbol) || symbol == '_' || symbol == '-'){
                        isValid = true;
                    }else{
                        isValid = false;
                        break;
                    }
                }

            }
            if (isValid){
                System.out.println(name);
            }
        }
    }
}
