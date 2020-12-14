package bg.softuni.javafundamentals;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = "^%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d*)\\$$";
        Pattern customerPattern = Pattern.compile(expression);

        double income = 0.0;
        while (true){
            String input = scanner.nextLine();
            if ("end of shift".equals(input)){
                break;
            }
            Matcher customerMatcher = customerPattern.matcher(input);
            if (customerMatcher.find()){
                String customerName = customerMatcher.group("name");
                String product = customerMatcher.group("product");
                double totalPrice = Integer.parseInt(customerMatcher.group("count"))
                        * Double.parseDouble(customerMatcher.group("price"));
                income += totalPrice;
                System.out.printf("%s: %s - %.2f%n", customerName, product, totalPrice);
            }

        }

        System.out.printf("Total income: %.2f", income);
    }
}
