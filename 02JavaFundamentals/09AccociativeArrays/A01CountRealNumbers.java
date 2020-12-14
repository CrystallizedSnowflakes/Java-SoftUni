package bg.softuni.javafundamentals;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A01CountRealNumbers {
    public static void main(String[] args) {
        Map<Double, Integer> numberOccurrences = new TreeMap<>();
        String[] numbersAsString = new Scanner(System.in).nextLine().split(" ");
        for (int i = 0; i < numbersAsString.length; i++) {
            double number = Double.parseDouble(numbersAsString[i]);

            Integer occurences = numberOccurrences.get(number);
            if (occurences == null){
                occurences = 0;
            }
            numberOccurrences.put(number, occurences + 1);
        }

        for (Map.Entry<Double, Integer> entry : numberOccurrences.entrySet()) {
            //System.out.println(entry.getKey() + " -> " + entry.getValue());
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
