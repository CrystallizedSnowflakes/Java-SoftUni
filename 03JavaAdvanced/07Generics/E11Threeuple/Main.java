package E11Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        String address = tokens[2];
        String town = tokens[3];
        Threeuple<String, String, String> personDetails = new Threeuple<>(name, address, town);
        System.out.println(personDetails);

        tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        int litres = Integer.parseInt(tokens[1]);
        boolean isDrunk = tokens[2].equals("drunk");
        Threeuple<String, Integer, Boolean> personBeer = new Threeuple<>(name, litres, isDrunk);
        System.out.println(personBeer);

        tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        double accountBalance = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];
        Threeuple<String, Double, String> numbers = new Threeuple<>(name, accountBalance, bankName);
        System.out.println(numbers);
    }
}
