package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte n = Byte.parseByte(scanner.nextLine());

        String biggestModelOfKeg = "";
        double biggestKeg = 0;
        for (byte i = 0; i < n; i++) {
            String modelOfKeg = scanner.nextLine();
            double radiusOfKeg = Double.parseDouble(scanner.nextLine());
            int heightOfKeg = Integer.parseInt(scanner.nextLine());

            double currentVolume = 3.14 * radiusOfKeg * radiusOfKeg * heightOfKeg;
            if (biggestKeg < currentVolume){
                biggestKeg = currentVolume;
                biggestModelOfKeg = modelOfKeg;
            }
        }
        System.out.println(biggestModelOfKeg);
    }
}
