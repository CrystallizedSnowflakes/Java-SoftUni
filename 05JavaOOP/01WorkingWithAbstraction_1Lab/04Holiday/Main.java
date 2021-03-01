package a04Holiday;

import IOUtils.ConsoleReader;
import IOUtils.InputParser;

public class Main {
    public static void main(String[] args) {
        goOnHoliday();
    }

    private static void goOnHoliday() {
        ConsoleReader reader = new ConsoleReader();
        String input = reader.readLine();

        String[] tokens = InputParser.parseArray(input);

        PriceCalculator calculator = new PriceCalculator(
                Double.parseDouble(tokens[0]),
                Integer.parseInt(tokens[1]),
                Season.valueOf(tokens[2].toUpperCase()),
                tokens[3].equals("SecondVisit") ? DiscountType.SECOND_VISIT :
                DiscountType.valueOf(tokens[3].toUpperCase()));

        System.out.printf("%.2f%n", calculator.calculateHoliday());
    }
}
