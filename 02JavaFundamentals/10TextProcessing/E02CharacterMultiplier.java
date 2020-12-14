package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        String first = tokens[0];
        String second = tokens[1];
        int sum = calculateSumOfStringsCharacters(first, second);
        System.out.println(sum);
    }

    private static int calculateSumOfStringsCharacters(String first, String second){
        int sum = 0;

        //short
        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            sum += first.charAt(i) * second.charAt(i);
        }

        //rest
        if (first.length() > second.length()){
            for (int i = second.length(); i < first.length(); i++) {
                sum  += first.charAt(i);
            }
        } else{
            for (int i = first.length(); i < second.length(); i++) {
                sum += second.charAt(i);
            }
        }

        return sum;
    }
}
