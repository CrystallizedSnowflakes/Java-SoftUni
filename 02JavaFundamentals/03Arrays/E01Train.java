package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E01Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = scanner.nextInt();
        int[]train = new int[wagons];

        int people = 0;
        for (int i = 0; i < train.length; i++) {
            train[i] = scanner.nextInt();
            people += train[i];
        }
        for (int wagon : train) {
            System.out.printf("%d ", wagon);
        }
        System.out.println();
        System.out.println(people);
    }
}
