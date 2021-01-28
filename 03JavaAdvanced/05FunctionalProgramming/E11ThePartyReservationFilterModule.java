package bg.softuni.javaadvanced;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E11ThePartyReservationFilterModule2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String action = tokens[0];
            String command = tokens[1];
            String parameter = tokens[2];
            String predicateName = tokens[1] + tokens[2];

            switch (action){
                case "Add filter":
                    Predicate<String> predicate = getPredicate(command, parameter);
                    predicates.put(predicateName, predicate);
                    break;
                case "Remove filter":
                    predicates.remove(predicateName);
                    break;
            }
            input = scanner.nextLine();
        }

        guests.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicates.values()){
                if (predicate.test(guest)){
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(e -> System.out.print(e +" "));
    }


    public static Predicate<String> getPredicate(String command, String parameter){
        Predicate<String> predicate;
        switch (command) {
            case "StartsWith":
                predicate = name -> name.startsWith(parameter);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(parameter);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(parameter);
                break;
            default:
                // "Contains"
                predicate = name -> name.contains(parameter);
                break;
        }
        return predicate;
    }
}
