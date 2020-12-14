package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E04ArrayRotationTemp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");
        int rotations = scanner.nextInt();

        if (rotations >= inputArr.length){
            rotations -= inputArr.length;
        }

        int count = 0;
        while(count != rotations){
            for (int i = 0; i < inputArr.length - 1; i++) { // move first el through all to the end !!!
                String temp = inputArr[i + 1];
                inputArr[i + 1] = inputArr [i];
                inputArr[i] = temp;
            }
            count++;
        }
        System.out.println(String.join(" ", inputArr));
    }
}
