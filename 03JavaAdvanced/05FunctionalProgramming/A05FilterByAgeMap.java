package bg.softuni.javaadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class A05FilterByAgeMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> tester = createTester(condition, age);

        String format = scanner.nextLine();
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        printFilteredStudent(people, tester, printer);
    }

    private static void printFilteredStudent(LinkedHashMap<String, Integer> people,
                                             Predicate<Integer> tester,
                                             Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey())))
                printer.accept(person);
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format){
            case "name age":
                printer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
                break;
            case "name":
                printer = person -> System.out.printf("%s%n", person.getKey());
                break;
            case "age":
                printer = person -> System.out.printf("%d%n", person.getValue());
                break;
        }
        return printer;
    }

    private static Predicate<Integer> createTester(String condition, int age) {
        Predicate<Integer> tester = null;
        switch (condition){
            case "younger":
                tester = x -> x <= age;
                break;
            case "older":
                tester = x -> x >= age;
                break;
        }
        return tester;
    }
}
