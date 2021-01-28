package bg.softuni.javaadvanced;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")){
            String[] tokens = input.split("\\s+");

            Predicate<String> predicate = getPredicate(tokens[1], tokens[2]);

            List<String> temp = new ArrayList<>();

            names.forEach(n -> {
                if (predicate.test(n)){
                    temp.add(n);
                }
            });

            switch (tokens[0]){
                case "Remove":
                    names.removeAll(temp);
                    break;
                case "Double":
                    names.addAll(temp);
                    break;
            }
            input = scanner.nextLine();
        }

        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(names.stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.joining(", ")) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String command, String parameter) {
        Predicate<String> predicate = null;

        if (command.equals("StartsWith")){
            predicate = str -> str.startsWith(parameter);
        } else if (command.equals("EndsWith")){
            predicate = str -> str.endsWith(parameter);
        } else {
            predicate = str -> str.length() == Integer.parseInt(parameter);
        }
        return predicate;
    }
}
