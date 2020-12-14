package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E05LoginCharAt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = "";
        for (int i = username.length()-1; i >= 0 ; i--) {
            password += username.charAt(i);
        }
        int count = 1;
        while(count <= 4){
            String input = sc.nextLine();

            if (input.equals(password)){
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
