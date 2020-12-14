package bg.softuni.javafundamentals;

import java.util.Scanner;

public class ME04RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= n; i++) {
            boolean isTrue = true;
            for (int devider = 2; devider <= Math.sqrt(i); devider++) {
                if (i % devider == 0) {
                    isTrue = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isTrue);
        }
    }
}
