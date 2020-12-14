package bg.softuni.basics;

import java.util.Scanner;

public class E05Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double remainderInLv = Double.parseDouble(scanner.nextLine());
        double remainderInCoins = Math.floor(remainderInLv * 100);

        int count = 0;
        while (remainderInCoins > 0){
                // 200 coins = 2 lv
            if (remainderInCoins >= 200){
                remainderInCoins -= 200;
                count++;
                // 100 coins = 1 lv
            } else if(remainderInCoins >= 100){
                remainderInCoins -= 100;
                count++;
                // 50 coins = 0.5 lv
            }else if(remainderInCoins >= 50) {
                remainderInCoins -= 50;
                count++;
                // 20 coins = 0.2 lv
            }else if(remainderInCoins >= 20){
                remainderInCoins -= 20;
                count++;
                // 10 coins = 0.1 lv
            }else if(remainderInCoins >= 10){
                remainderInCoins -= 10;
                count++;
                // 5 coins = 0.05 lv
            }else if(remainderInCoins >= 5){
                remainderInCoins -= 5;
                count++;
                // 2 coins = 0.02 lv
            }else if(remainderInCoins >= 2){
                remainderInCoins -= 2;
                count++;
                // 1 coins = 0.01 lv
            }else if(remainderInCoins >= 1){
                remainderInCoins -= 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
