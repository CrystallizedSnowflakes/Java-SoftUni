package bg.softuni.javafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME03TakeOrSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();

        List<Integer> digits = new ArrayList<>();
        List<Character> nonDigits = new ArrayList<>();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            if(Character.isDigit(encryptedMessage.charAt(i))){
                digits.add(Integer.parseInt(String.valueOf(encryptedMessage.charAt(i))));
            }else{
                nonDigits.add(encryptedMessage.charAt(i));
            }
        }

        List<Integer> takeEvenList = new ArrayList<>();
        List<Integer> skipOddList = new ArrayList<>();

        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 != 0){
                skipOddList.add(digits.get(i));
            }else{
                takeEvenList.add(digits.get(i));
            }
        }

        String decryptedMessage = "";

        int count = 0;
        for (int j = 0; j < nonDigits.size() && count < takeEvenList.size();) {
            int takeCount = takeEvenList.get(count);
            int skipCount = skipOddList.get(count);
            while (takeCount != 0 && j < nonDigits.size()){
                decryptedMessage += String.valueOf(nonDigits.get(j));
                j++;
                takeCount--;
            }
            j += skipCount;
            count++;
        }

        System.out.println(decryptedMessage);
    }
}
