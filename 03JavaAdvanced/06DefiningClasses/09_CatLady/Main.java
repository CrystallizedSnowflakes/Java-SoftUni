package catLady_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("End")){
            String[] tokens = line.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double specialParam = Double.parseDouble(tokens[2]);
            Cat cat;
            switch (breed){
                case "Siamese":
                    cat = new Siamese(name, specialParam);
                    break;
                case "Cymric":
                    cat = new Cymric(name, specialParam);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, specialParam);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + breed);
            }
            cats.put(name, cat);
            line = scanner.nextLine();
        }

        String name = scanner.nextLine();
        String output = cats.get(name).toString();
        System.out.println(output);
    }
}
