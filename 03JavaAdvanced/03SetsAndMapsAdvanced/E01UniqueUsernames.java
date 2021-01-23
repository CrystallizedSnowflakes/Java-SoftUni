package bg.softuni.javaadvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class E01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> names = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        while(n-- > 0){
            String name = scanner.nextLine();
            names.add(name);
        }

/*        for (String name : names) {
            System.out.println(name);
        }*/

        names.forEach(System.out::println);
    }
}
