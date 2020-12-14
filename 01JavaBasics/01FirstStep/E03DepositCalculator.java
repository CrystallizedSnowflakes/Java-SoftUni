package bg.softuni.javabasics;

import java.util.Scanner;

public class E03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositSum = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double sum = depositSum + months * ((depositSum * (percent / 100)) / 12);
        System.out.println(sum);
    }
}
// 5.7% = (5.7 / 100) = 0.057
