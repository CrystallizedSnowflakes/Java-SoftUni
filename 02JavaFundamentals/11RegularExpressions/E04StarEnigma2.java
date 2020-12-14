package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E04StarEnigma2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        String decryptedRegEx = "(?i)[star]";
        Pattern decryptedPat = Pattern.compile(decryptedRegEx);

        String encryptedRegEx = "@(?<name>[A-Za-z]+)[^@!>:\\-]*:(?<population>\\d+)[^@!>:\\-]*!(?<type>[A|D])![^@!>:\\-]*->(?<soldiers>\\d+)";
        Pattern encryptedPat = Pattern.compile(encryptedRegEx);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String decryptedMsg = scanner.nextLine();
            int keyCount = 0;

            Matcher decryptedMatch = decryptedPat.matcher(decryptedMsg);

            while (decryptedMatch.find()) {
                keyCount++;
            }

            StringBuilder encryptedMsg = new StringBuilder();
            for (int j = 0; j < decryptedMsg.length(); j++) {
                encryptedMsg.append((char) (decryptedMsg.charAt(j) - keyCount));
            }

            decryptedMatch = encryptedPat.matcher(encryptedMsg.toString());
            if (decryptedMatch.find()) {
                String planet = decryptedMatch.group("name");
                String type = decryptedMatch.group("type");
                if (type.equals("A")) {
                    attacked.add(planet);
                } else {
                    destroyed.add(planet);
                }
            }
        }

        System.out.println("Attacked planets: " + attacked.size());
        attacked.stream().sorted((a, b) -> a.compareTo(b))
                .forEach(a -> System.out.println("-> " + a));
        System.out.println("Destroyed planets: " + destroyed.size());
        destroyed.stream().sorted((a, b) -> a.compareTo(b))
                .forEach(a -> System.out.println("-> " + a));
    }
}
