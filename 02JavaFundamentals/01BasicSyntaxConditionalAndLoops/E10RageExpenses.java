package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E10RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGameCount = scanner.nextInt();
        double headsetPrice = scanner.nextDouble();
        double mousePrice = scanner.nextDouble();
        double keyboardPrice = scanner.nextDouble();
        double displayPrice = scanner.nextDouble();

        double expenses = 0;

        int count = 0;
        for (int i = 1; i <= lostGameCount; i++) {
            if (i % 2 == 0){
                expenses += headsetPrice;
            }

            if (i % 3 == 0){
                expenses += mousePrice;
            }

            if ((i % 2 == 0) && (i % 3 == 0)){
                expenses += keyboardPrice;
                count += 1;
                if (count % 2 == 0){
                    expenses += displayPrice;
                }
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
