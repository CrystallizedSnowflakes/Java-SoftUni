package e03ShoppingSpree2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        try {
            Arrays.stream(scan.nextLine().split(";"))
                    .forEach(p -> {
                        String[] tokens = p.split("=");
                        Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                        people.putIfAbsent(tokens[0], person);
                    });


            Arrays.stream(scan.nextLine().split(";"))
                    .forEach(p -> {
                        String[] tokens = p.split("=");
                        Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                        products.putIfAbsent(tokens[0], product);
                    });
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String input = scan.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");

            String personName = tokens[0];
            String productName = tokens[1];

            Person person = people.get(personName);
            Product product = products.get(productName);

            if (person == null || product == null) {
                continue;
            }

            try {
                person.buyProduct(product);
                System.out.println(String.format("%s bought %s", person.getName(), product.getName()));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = scan.nextLine();
        }

        for (Person person : people.values()) {
            System.out.println(person.toString());
        }
    }
}
