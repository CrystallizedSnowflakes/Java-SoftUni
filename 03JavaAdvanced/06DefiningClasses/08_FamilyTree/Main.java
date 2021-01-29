package familyTree_08;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> personList = new ArrayList<>();
        ArrayDeque<String> lines = new ArrayDeque<>();

        String topRelative = scanner.nextLine();
        Person person = new Person(topRelative);

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            if (input.contains("-")) {
                lines.offer(input);
            } else {
                if (input.contains(topRelative)) {
                    topRelative = input;
                    person = new Person(input);
                }
                personList.add(input);
            }
            input = scanner.nextLine();
        }

        while (!lines.isEmpty()) {
            setParentAndChild(lines.pop(), person, topRelative, personList);
        }

        System.out.print(person);
    }

    private static void setParentAndChild(String command, Person person, String topRelative, List<String> personList) {
        String parent = command.split(" - ")[0];
        String child = command.split(" - ")[1];
        for (String data : personList) {
            if (data.contains(parent)) {
                parent = data;
                continue;
            }
            if (data.contains(child)) {
                child = data;
            }
        }

        if (topRelative.contains(parent)) {
            person.setChildren(child);
        }

        if (topRelative.contains(child)) {
            person.setParents(parent);
        }
    }
}
