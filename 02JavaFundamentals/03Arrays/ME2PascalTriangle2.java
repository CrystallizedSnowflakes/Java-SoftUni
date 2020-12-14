package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME2PascalTriangle2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(1);

        if (n == 1)
        {
            return;
        }


        int[] beforArr = {1, 1};

        System.out.printf("1 1%n");
        if (n == 2)
        {
            return;
        }

        for (int i = 3; i <= n; i++)
        {
            int[] nextArr = new int[beforArr.length + 1];

            for (int j = 1; j < nextArr.length - 1; j++)
            {
                nextArr[0] = 1;
                nextArr[nextArr.length - 1] = 1;

                nextArr[j] = beforArr[j - 1] + beforArr[j];
            }
            for (int j = 0; j < nextArr.length; j++) {
                System.out.print(nextArr[j] + " ");
            }
            beforArr = nextArr;
            System.out.println();
        }
    }
}
