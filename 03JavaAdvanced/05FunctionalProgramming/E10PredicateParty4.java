package bg.softuni.javaadvanced;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10PredicateParty4 {

    static List<String> names = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        Consumer<List<String>> printNames = list -> {
            if (!list.isEmpty()){
                System.out.println(list.stream()
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.joining(", ")) + " are going to the party!");
            } else {
                System.out.println("Nobody is going to the party!");
            }
        };


        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            String action = tokens[0];
            String command = tokens[1];
            String parameter = tokens[2];

            switch (action){
                case "Remove":
                    removeName(getPredicate(command, parameter));
                    break;
                case "Double":
                    addOneMore(getPredicate(command, parameter));
                    break;
            }

            input = scanner.nextLine();
        }
        printNames.accept(names);
    }

    private static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        names.stream()
                .filter(predicate)
                .forEach(namesToAdd::add);
        names.addAll(namesToAdd);
    }

    private static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    public static Predicate<String> getPredicate(String command, String parameter){
        Predicate<String> predicate = null;
        if (command.equals("StartsWith")){
            predicate = name -> name.startsWith(parameter);
        } else if(command.equals("EndsWith")){
            predicate = name -> name.endsWith(parameter);
        } else {
            predicate = name -> name.length() == Integer.parseInt(parameter);
        }
        return predicate;
    }
}
