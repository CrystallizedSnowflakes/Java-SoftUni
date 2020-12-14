package bg.softuni.javabasics;

import java.util.Scanner;

public class A12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());
        double commission = 0.0;

        if (sales < 0) {
            System.out.println("error");
            return;
        }

        switch(city){
            case "Sofia":
                if(0 <= sales && sales <= 500){
                    commission = sales * 0.05;
                }else if(500 < sales && sales <= 1000){
                    commission = sales * 0.07;
                }else if (1000 < sales && sales <= 10000){
                    commission = sales * 0.08;
                }else{ // 10000 < sales
                    commission = sales * 0.12;
                }
                break;
            case "Varna":
                if(0 <= sales && sales <= 500){
                    commission = sales * 0.045;
                }else if(500 < sales && sales <= 1000){
                    commission = sales * 0.075;
                }else if (1000 < sales && sales <= 10000){
                    commission = sales * 0.10;
                }else{ // 10000 < sales
                    commission = sales * 0.13;
                }
                break;
            case "Plovdiv":
                if(0 <= sales && sales <= 500){
                    commission = sales * 0.055;
                }else if(500 < sales && sales <= 1000){
                    commission = sales * 0.08;
                }else if (1000 < sales && sales <= 10000){
                    commission = sales * 0.12;
                }else{ // 10000 < sales
                    commission = sales * 0.145;
                }
                break;
            default:
                System.out.println("error");
                break;
        }
        if (commission > 0){
            System.out.printf("%.2f", commission);
        }
    }
}
