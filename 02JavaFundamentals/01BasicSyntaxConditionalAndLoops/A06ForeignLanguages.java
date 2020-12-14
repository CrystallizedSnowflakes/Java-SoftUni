package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A06ForeignLanguages {
    public static void main(String[] args) {
        String country = new Scanner(System.in).nextLine().toLowerCase();
        String language;
        switch (country){
            case "england":
            case "usa":
                language = "English";
                break;
            case "spain":
            case "argentina":
            case "mexico":
                language = "Spanish";
                break;
            default:
                language = "unknown";
                break;
        }
        System.out.print(language);
    }
}
