package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E04ArrayRotation2For {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int rotations = scanner.nextInt();

        for (int i = 0; i < rotations; i++) {
            String firstElement = array[0];
            // shift left
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            //add first element to the last position
            array[array.length - 1] = firstElement;
        }
//        for (String s : array) {
//            System.out.print(s + " ");
//    }
        System.out.println(String.join(" ",array));

    }
}
