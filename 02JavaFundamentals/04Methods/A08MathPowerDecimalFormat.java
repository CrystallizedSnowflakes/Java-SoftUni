package bg.softuni.javafundamentals;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A08MathPowerDecimalFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = scanner.nextDouble();
        int power = scanner.nextInt();

        System.out.println(new DecimalFormat("0.####").format(mathPower(number,power)));
    }

    //II.	Returning Values and Overloading
    private static double mathPower(double number, int power) {
        double result = Math.pow(number, power);
        return result;
    }
}
