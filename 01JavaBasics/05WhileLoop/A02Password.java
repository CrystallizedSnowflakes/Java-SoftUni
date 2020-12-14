package bg.softuni.basics;

import java.util.Scanner;

public class A02Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();

        while (true){
            String tryPassword = scanner.nextLine();
            if (tryPassword.equals(password)) {
                break;
            }
        }
        System.out.printf("Welcome %s!", username);
    }
}
