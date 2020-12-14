package bg.softuni.javafundamentals;

import java.util.Scanner;

public class E07AppendArrays2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //7 | 4  5|1 0| 2 5 |3
        String[]arrays = scanner.nextLine().split("\\|"); //"7_" "_4 5" "1 0" "_2 5" "3"
        String result = "";

        for (int i = arrays.length - 1; i >=0;  i--) {
            String[]currentArr = arrays[i].split("\\s+"); //first space is not cut {"", "2", "5"}

            for (int j = 0; j < currentArr.length; j++) {
                if (!currentArr[j].equals("")){
                    result += currentArr[j] + " "; //{3 2 5 1 0 4 5 7}
                }
            }
        }
        System.out.println(result);
        //3 2 5 1 0 4 5 7
    }
}
