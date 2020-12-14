package bg.softuni.javafundamentals;

import java.util.Scanner;

public class A05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine().toLowerCase();
        int quantity = scanner.nextInt();

        getPriceOfAnOrder(product,quantity);
    }

    //I.	Declaring and Invoking Methods (void = print)
    private static void getPriceOfAnOrder(String product, int quantity) {
        double sum = 0.0;
        switch(product){
            case "coffee":
                sum = quantity * 1.50;
                break;
            case "water":
                sum = quantity * 1.00;
                break;
            case "coke":
                sum = quantity * 1.40;
                break;
            case "snacks":
                sum = quantity * 2.00;
                break;
            default:
                break;
        }
        System.out.printf("%.2f", sum);
    }

}
