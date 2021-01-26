package bg.softuni.javaadvanced;

import java.util.Scanner;
import java.util.function.Consumer;

public class E02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> printer = strArr -> {
            for (String s : strArr) {
                System.out.println("Sir " + s);
            }
        };

        printer.accept(names);
    }
}
