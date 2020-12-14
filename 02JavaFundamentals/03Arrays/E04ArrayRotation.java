package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");
        int rotations = scanner.nextInt();

        if (rotations >= inputArr.length){
            rotations -= inputArr.length;
        }

        String[] firstPart = new String[rotations];
        String[] secondPart = new String[inputArr.length - rotations];

        for (int i = 0; i < firstPart.length; i++) {
            firstPart[i] = inputArr[i];
        }
        int count = 0;
        for (int j = rotations; j < inputArr.length; j++) {
            secondPart[count] = inputArr[j];
            count++;
        }
        System.out.print(String.join(" ", secondPart) + " " + String.join(" ", firstPart));
    }
}
