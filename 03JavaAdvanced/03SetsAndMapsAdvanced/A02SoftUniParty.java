package bg.softuni.javaadvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class A02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Set
        Set<String> guests = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")){
            guests.add(input);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("END")){
            guests.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            if (Character.isDigit(guest.charAt(0))){
                System.out.println(guest);
            }
        }

        for (String guest : guests) {
            if (!Character.isDigit(guest.charAt(0))){
                System.out.println(guest);
            }
        }
    }
}
