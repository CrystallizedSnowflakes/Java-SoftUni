package bg.softuni.javafundamentals;

import java.util.*;

public class  E09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> sides = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Lumpawaroo".equals(input)){

            String[] tokens;
            String forceSide;
            String forceUser;
            if (input.contains("|")){
                tokens = input.split(" \\| ");
                forceSide = tokens[0];
                forceUser = tokens[1];
                boolean check = false;
                for(Map.Entry<String, List<String>> current : sides.entrySet()){
                    if(current.getValue().contains(forceUser)){
                        check = true;
                        break;
                    }
                }

                if(!check){
                    if(!sides.containsKey(forceSide)){
                        sides.put(forceSide, new ArrayList<>());
                        sides.get(forceSide).add(forceUser);
                    }
                    else if(sides.containsKey(forceSide) && !sides.get(forceSide).contains(forceUser)){
                        sides.get(forceSide).add(forceUser);
                    }
                }

            } else {
                tokens = input.split(" -> ");
                forceUser = tokens[0];
                forceSide = tokens[1];
                for (Map.Entry<String, List<String>> current : sides.entrySet()) {
                    if (current.getValue().contains(forceUser)) {
                        sides.get(current.getKey()).remove(forceUser);
                        break;
                    }
                }
                if (!sides.containsKey(forceSide)){
                    sides.putIfAbsent(forceSide, new ArrayList<>());
                }
                sides.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }

        sides.entrySet()
                .stream()
                .filter(users -> users.getValue().size() > 0)
                .sorted((f, s) -> {
                    int result = s.getValue().size() - f.getValue().size(); //sorted by size descending
                    if (result == 0){
                    result = f.getKey().compareTo(s.getKey()); //by name
                }
                return result;
                }).forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());

                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(user -> System.out.printf("! %s%n", user));
                });
    }
}
