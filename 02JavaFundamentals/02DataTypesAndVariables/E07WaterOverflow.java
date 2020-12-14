package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputs = scanner.nextInt();
        int capacity = 255;
        for (int i = 0; i < inputs; i++) {
            int liters = scanner.nextInt();
            if (liters > capacity){
                System.out.println("Insufficient capacity!");
            }else{
                capacity -=liters;
            }
        }
        int tank = 255 - capacity;
        System.out.println(tank);
    }
}
