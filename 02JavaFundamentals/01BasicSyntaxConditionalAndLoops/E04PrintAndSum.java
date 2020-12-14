package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E04PrintAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNum = sc.nextInt();
        int endNum = sc.nextInt();
        int sum = 0;
        for (int i = startNum; i <= endNum; i++){
            System.out.print(i + " ");
            sum += i;
        }
        System.out.printf("%nSum: %d", sum);
    }
}
