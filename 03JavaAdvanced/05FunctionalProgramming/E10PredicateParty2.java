package bg.softuni.javaadvanced;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class E10PredicateParty2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
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


        while (!input.equals("Party!")){
            String[] tokens = input.split("\\s+");
            String action = tokens[0];
            String command = tokens[1];
            String parameter = tokens[2];

            BiPredicate<String, String> isNameStartsWith = String::startsWith;
            BiPredicate<String, String> isNameEndWith = String::endsWith;
            BiPredicate<String, String> hasNameSameLength = (name, param) -> name.length() == Integer.parseInt(param);

            List<String> filteredByCriteria = new ArrayList<>();

            for (String name : names) {
                switch (command){
                    case "StartsWith":
                        if (isNameStartsWith.test(name, parameter)) {
                            filteredByCriteria.add(name);
                        }
                        break;
                    case "EndsWith":
                        if (isNameEndWith.test(name, parameter)) {
                            filteredByCriteria.add(name);
                        }
                        break;
                    case "Length":
                        if (hasNameSameLength.test(name, parameter)) {
                            filteredByCriteria.add(name);
                        }
                        break;
                }
            }

            switch (action){
                case "Remove":
                    names.removeAll(filteredByCriteria);
                    break;
                case "Double":
                    names.addAll(filteredByCriteria);
                    break;
            }

            input = scanner.nextLine();
        }

        printNames.accept(names);
    }
}
