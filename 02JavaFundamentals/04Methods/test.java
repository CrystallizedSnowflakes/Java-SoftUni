package bg.softuni.javafundamentals;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        int[]numbers = {5,7,9,1,3};

        System.out.println(Arrays.toString(numbers));
        int num = 1;
        int num2 = 2;
        switch (num){
            case 1:
                switch (num2){
                    case 1:

                        break;
                }
                break;
        }

        printFirstOddNumsCount(numbers, 2);


//        System.out.println("exchange 1");
//        System.out.println(Arrays.toString(numbers));
//        printLastEvenNumsCount(numbers, 2);
//
//        System.out.println(Arrays.toString(numbers));
//
//        printLastOddNumsCount(numbers, 2);
//        System.out.println(Arrays.toString(numbers));
//
//        printFirstEvenNumsCount(numbers, 2);

    }

    private  static void printFirstOddNumsCount(int[]arr, int count){
        String nums = "";
        for (int i = 0; i <= count; i++) {
            if (arr[i] % 2 != 0){
                nums +=  arr[i];
                count--;
            }
        }

        String[]output = nums.split("");
        System.out.println(Arrays.toString(output));
    }

    private  static void printFirstEvenNumsCount(int[]arr, int count){
        String nums = "";
        for (int i = 0; i <= count; i++) {
            if (arr[i] % 2 == 0){
                nums +=  arr[i];
                count--;
            }
        }

        String[]output = nums.split("");
        System.out.println(Arrays.toString(output));
    }

    private  static void printLastEvenNumsCount(int[]arr, int count){
        String nums = "";
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (count > 0 && arr[i] % 2 == 0){
                nums +=  arr[i];
                count--;
            }
        }
        String[]output = nums.split("");
        for (int i = 0; i < output.length / 2; i++) {
            int swapIndex = output.length - 1 - i;
            String oldNumbersI = output[i];
            output[i] = output[swapIndex];
            output[swapIndex] = oldNumbersI;
        }

        System.out.println(Arrays.toString(output));
    }

    private  static void printLastOddNumsCount(int[]arr, int count){
        String nums = "";
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (count > 0 && arr[i] % 2 != 0){
                nums +=  arr[i];
                count--;
            }
        }
        String[]output = nums.split("");
        for (int i = 0; i < output.length / 2; i++) {
            int swapIndex = output.length - 1 - i;
            String oldNumbersI = output[i];
            output[i] = output[swapIndex];
            output[swapIndex] = oldNumbersI;
        }

        System.out.println(Arrays.toString(output));
    }
}
