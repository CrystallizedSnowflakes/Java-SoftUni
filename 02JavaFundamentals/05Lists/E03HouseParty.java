package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<String>names = new ArrayList<>();

        while (number != 0) {
            String[] commands = scanner.nextLine().split("\\s+");

            String currentName = commands[0];
            if (commands.length == 3) {
                if (!names.contains(currentName)) {
                    names.add(currentName);
                } else {
                    System.out.printf("%s is already in the list!%n", currentName);
                }
            } else if (commands.length == 4) {
                if (names.contains(currentName)) {
                    names.remove(currentName);
                } else {
                    System.out.printf("%s is not in the list!%n", currentName);
                }
            }
            number--;
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
