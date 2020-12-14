package bg.softuni.basics;

import java.util.Scanner;

public class A04Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int i = 1;
        while (i <= n){
            System.out.println(i);
            i = i * 2 + 1;
        }
    }
}
