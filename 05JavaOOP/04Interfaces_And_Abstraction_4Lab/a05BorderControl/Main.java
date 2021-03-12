package a05BorderControl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Identifiable> society = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String [] tokens = input.split("\\s+");
            if (tokens.length == 3){
                String citizenName = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Citizen citizen = new Citizen(citizenName, age, id);
                society.put(citizenName, citizen);

            } else {
                String model = tokens[0];
                String robotId = tokens[1];
                Robot robot = new Robot(model, robotId);
                society.put(model, robot);
            }
            input = scanner.nextLine();
        }

        String fakeDigitsAtTheEnd = scanner.nextLine();

        society.values().stream()
                .filter(identifiable -> identifiable.getId().endsWith(fakeDigitsAtTheEnd))
                .forEach(identifiable -> System.out.println(identifiable.getId()));
    }
}
