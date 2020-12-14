package bg.softuni.javafundamentals;

import java.util.*;

public class E08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<String>> companies = new TreeMap<>();

        while (true){
            String[] tokens = scanner.nextLine().split(" -> ");
            if (tokens[0].equals("End")){
                break;
            }
            String companyName = tokens[0];
            String employeeID = tokens[1];

            companies.putIfAbsent(companyName, new ArrayList<>());
            if (!companies.get(companyName).contains(employeeID)){
                companies.get(companyName).add(employeeID);
            }
        }

        companies.entrySet()
                .forEach(k -> {
                    System.out.println(k.getKey());
                    k.getValue()
                            .forEach(v -> System.out.printf("-- %s%n", v));
                });

    }
}
