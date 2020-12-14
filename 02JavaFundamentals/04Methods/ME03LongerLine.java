package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());

        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());

        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        double first = longestLine(x1, y1, x2, y2);
        double second = longestLine(x3, y3, x4, y4);

        if (first >= second)
        {
            closestPoint(x1, y1, x2, y2);
        }
        else
        {
            closestPoint(x3, y3, x4, y4);
        }
    }
    static double longestLine(int x1, int y1, int x2, int y2)
    {
        double sum = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return sum;
    }
    static void closestPoint(int x1, int y1, int x2, int y2)
    {
        double first = Math.sqrt(Math.pow(y1, 2) + Math.pow(x1, 2));
        double second = Math.sqrt(Math.pow(y2, 2) + Math.pow(x2, 2));

        if (first <= second)
        {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        }
        else
        {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        }
    }
}
