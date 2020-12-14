package bg.softuni.javabasics;

import java.util.Scanner;

public class E01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double income = 0.0;

        if ("Premiere".equals(projection)){
            income = rows * columns * 12.0;
        }else if("Normal".equals(projection)){
            income = rows * columns * 7.50;
        }else if("Discount".equals(projection)){
            income = rows * columns * 5.0;
        }

        System.out.printf("%.2f leva", income);
    }
}
