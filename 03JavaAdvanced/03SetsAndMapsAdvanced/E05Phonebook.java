package bg.softuni.javaadvanced;

import java.util.HashMap;
import java.util.Scanner;

public class E05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        HashMap<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")){
            String[]tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];
            phonebook.put(name, phone);
            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!name.equals("stop")){
            if (phonebook.containsKey(name)){
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scanner.nextLine();
        }
    }
}
