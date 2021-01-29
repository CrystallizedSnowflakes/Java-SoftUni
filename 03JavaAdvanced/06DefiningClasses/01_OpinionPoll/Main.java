package opinionPoll_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            //if (age > 30) {
                Person person = new Person(name, age);
                people.add(person);
            //}
        }

        // people.sort(Comparator.comparing(Person::getName));
        // people.sort(Comparator.comparing(p -> p.getName()));
/*        for (Person person : people) {
            System.out.println(person.toString());
        }*/

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::toString)
                .forEach(System.out::println);
    }
}
