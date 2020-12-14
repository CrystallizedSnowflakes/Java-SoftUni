package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        switch(input){
            case "int":
                int number = Integer.parseInt(scanner.nextLine());
                System.out.println(multiply(number));
                break;
            case "real":
                double realNumber = Double.parseDouble(scanner.nextLine());
                System.out.println(multiply(realNumber));
                break;
            case "string":
                String str = scanner.nextLine();
                System.out.println(multiply(str));
                break;
        }
    }
    private static String multiply(int number){
        return String.format("%d", number * 2);
    }

    private static String multiply(double number){
        return String.format("%.2f", number * 1.5);
    }

    private static String multiply(String str){
        return String.format("$%s$", str);
    }
}
