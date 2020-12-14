package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class E06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        while (true){
            String[] tokens = scanner.nextLine().split(" : ");
            if ("end".equals(tokens[0])){
                break;
            }

            String course = tokens[0];
            String studentName = tokens[1];

            if (!courses.containsKey(course)){
                courses.put(course, new ArrayList<>());
            }
            courses.get(course).add(studentName);
        }

        courses.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(e -> System.out.printf("-- %s%n", e));
                });
    }
}
