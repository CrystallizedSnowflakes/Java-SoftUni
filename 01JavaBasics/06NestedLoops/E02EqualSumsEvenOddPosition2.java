package bg.softuni.javabasics;

import java.util.Scanner;

public class E02EqualSumsEvenOddPosition2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= secondNum ; i++) {
            //3.	Вземете числото на текущата позиция като текст, като го конкатенирате с празен стринг
            String currentNum = "" + i;
            int oddSum = 0;
            int evenSum = 0;
            for (int j = 0; j < currentNum.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNum.charAt(j));
                if (j % 2 == 0){
                    evenSum += currentDigit;
                }else{
                    oddSum += currentDigit;
                }
            }
            if (oddSum == evenSum){
                System.out.print(i + " ");
            }
        }
    }
}
