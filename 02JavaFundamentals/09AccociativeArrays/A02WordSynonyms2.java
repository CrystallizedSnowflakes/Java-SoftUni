package bg.softuni.javafundamentals;

import java.util.*;

public class A02WordSynonyms2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }

        for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }
    }
}
