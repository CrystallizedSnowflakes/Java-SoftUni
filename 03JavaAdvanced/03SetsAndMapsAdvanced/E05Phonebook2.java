package bg.softuni.javaadvanced;

import java.util.HashMap;
import java.util.Scanner;

public class E05Phonebook2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        while (true){
            String input = scanner.nextLine();
            if (input.equals("search")){
                String searchName = scanner.nextLine();
                while (!searchName.equals("stop")){
                    if (!phonebook.containsKey(searchName)){
                        System.out.printf("Contact %s does not exist.%n", searchName);
                    } else {
                        System.out.printf("%s -> %s%n", searchName, phonebook.get(searchName));
                    }
                    searchName = scanner.nextLine();
                }
                break;
            } else {
                String name = input.split("-")[0];
                String number = input.split("-")[1];
                phonebook.put(name, number);
            }
        }
    }
}
