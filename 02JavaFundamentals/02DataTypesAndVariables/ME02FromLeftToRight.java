package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME02FromLeftToRight {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split(" ");
            long leftNum = Long.parseLong(input[0]);
            long rightNum = Long.parseLong(input[1]);

            long biggestNum = Math.max(leftNum, rightNum);
            int sum = 0;

            while (biggestNum != 0) {
                sum += biggestNum % 10;
                biggestNum /= 10;
            }
            System.out.println(Math.abs(sum));

        }
    }
}
