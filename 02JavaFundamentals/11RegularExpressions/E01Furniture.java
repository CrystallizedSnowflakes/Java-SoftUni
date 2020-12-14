package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = ">>(?<name>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(expression);
        List<String> furniture = new ArrayList<>();
        double cost = 0.0;

        while (!text.equals("Purchase")){
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furniture.add(name);
                cost += (price * quantity);
            }
            text = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        furniture.forEach(f -> System.out.println(f));
        System.out.printf("Total money spend: %.2f", cost);
    }
}
