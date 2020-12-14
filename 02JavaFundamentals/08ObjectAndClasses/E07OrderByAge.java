package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E07OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        while (true){
            String line = scanner.nextLine();
            if (line.equals("End")){
                break;
            }

            String[] elements = line.split(" ");
            String name = elements[0];
            String id = elements[1];
            int age = Integer.parseInt(elements[2]);

            Person person = new Person(name, id, age);
            people.add(person);
        }

        // order by age ascending
        // p -> person
        people.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(person -> System.out.println(person.toString()));
    }

    public static class Person{
        //FIELDS
        String firstName;
        String id;
        int age;

        public Person(String firstName, String id, int age) {
            this.firstName = firstName;
            this.id = id;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getID() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getFirstName(), getID(), getAge());
        }
    }
}
