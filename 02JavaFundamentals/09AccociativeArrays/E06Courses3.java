package bg.softuni.javafundamentals;

import java.util.*;

public class E06Courses3 {
    public static void main(String[] args) {
        Map<String, List<String>> courseRegister = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"end".equals(input)){
            String[] tokens = input.split(" : ");
            String course = tokens[0];
            String student = tokens[1];
            courseRegister.putIfAbsent(course, new ArrayList<>());
            courseRegister.get(course).add(student);
            input = scanner.nextLine();
        }

        courseRegister.entrySet()
                .stream()
                .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(s-> {
                    System.out.printf("%s: %s%n", s.getKey(), s.getValue().size());
                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(e -> System.out.printf("-- %s%n", e));
                });
    }
}
