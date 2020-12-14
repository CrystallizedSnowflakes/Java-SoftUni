package bg.softuni.javafundamentals;

import java.util.Scanner;
import java.lang.StringBuilder;


public class E05Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder username = new StringBuilder(sc.nextLine());

        StringBuilder correctPassword = new StringBuilder(username);
        correctPassword.reverse();
        int count = 1;
        while(count <= 4){
            String password = sc.nextLine();

            int comparison = password.compareTo(correctPassword.toString()); //returns 0 if it's true, negative digit if it's false
            // use compareTo for Strings
            if (0 == comparison){
                System.out.printf("User %s logged in.", username);
                break;
            }else if(count < 4 ){
                System.out.println("Incorrect password. Try again.");
            }else{
                System.out.printf("User %s blocked!", username);
            }
            count++;
        }
    }
}
