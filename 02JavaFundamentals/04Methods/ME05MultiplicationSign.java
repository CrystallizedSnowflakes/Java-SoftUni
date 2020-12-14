package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int negativeCounter = 0;
        boolean isThereZero = false;

        for (int i = 0; i < 3; i++)
        {
            double currentNumber = Double.parseDouble(scanner.nextLine());

            if (currentNumber < 0)
            {
                negativeCounter++;
            }

            if (currentNumber == 0)
            {
                isThereZero = true;
            }
        }

        if (isThereZero)
        {
            System.out.println("zero");
        }
        else if (negativeCounter % 2 == 1) //negativeCounter = 1
        {
            System.out.println("negative");
        }
        else //negativeCounter = 0
        {
            System.out.println("positive");
        }
    }
}
