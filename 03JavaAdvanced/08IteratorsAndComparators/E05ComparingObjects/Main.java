package E05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine());
        Person targetPerson = people.get(index - 1);

        int equalPeople = 0;
        for (Person person : people) {
            if (person.compareTo(targetPerson) == 0) {
                equalPeople++;
            }
        }

        // if target person is met once there is no matches
        if (equalPeople == 1){
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d",
                    equalPeople,
                    people.size() - equalPeople,
                    people.size());
        }
    }
}
