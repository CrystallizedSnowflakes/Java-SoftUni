package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E01Ages {
    public static void main(String[] args) {
        int age = new Scanner(System.in).nextInt();
        String output;
        if (0<=age && age<=2){
            output = "baby";
        }else if(3<=age && age<=13){
            output = "child";
        }else if(14<=age && age<=19){
            output = "teenager";
        }else if(20<=age && age <=65){
            output = "adult";
        }else if(age>=66){
            output = "elder";
        }else{
            output = "Not born yet";
        }
        System.out.print(output);
    }
}
