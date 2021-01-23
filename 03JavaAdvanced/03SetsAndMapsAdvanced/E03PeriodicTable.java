package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class E03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> chemicalElements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0 ){
            String[] elements = scanner.nextLine().split("\\s+");
            for (int i = 0; i < elements.length; i++) {
                chemicalElements.addAll(Arrays.asList(elements));
            }
        }

        //chemicalElements.forEach(e -> System.out.print(e + " "));
        System.out.println(String.join(" ", chemicalElements));
    }
}
