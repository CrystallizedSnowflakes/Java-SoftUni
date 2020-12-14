package bg.softuni.javabasics;

import java.util.Scanner;

public class E03SpeedInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double speed = Double.parseDouble(scanner.nextLine());

        if (speed <= 10){
            System.out.println("slow");
        //}else if(10 < speed && speed <= 50){
        }else if(speed <= 50){
            System.out.println("average");
        //}else if(50 < speed && speed <= 150){
        }else if(speed <= 150){
            System.out.println("fast");
        //}else if(150 < speed && speed <= 1000){
        }else if(speed <= 1000){
            System.out.println("ultra fast");
        }else{
            System.out.println("extremely fast");
        }
    }
}
