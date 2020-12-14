package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;


public class E11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String input = scanner.nextLine().toLowerCase();

        while (!input.equals("end")){
            String[] commands = input.split(" ");
            String command = commands[0];
            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(commands[1]);
                    if (index >= 0 && index < numbers.length) {
                        exchangeArray(numbers, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    String typeMax = commands[1];
                    switch (typeMax){
                        case "odd":
                            int indexOddMax = findMaxOddElementIndex(numbers);
                            if (indexOddMax >= 0){
                                System.out.println(indexOddMax);
                            }else{
                                System.out.println("No matches");
                            }
                            break;
                        case "even":
                            int indexEvenMax = findMaxEvenElementIndex(numbers);
                            if (indexEvenMax >= 0){
                                System.out.println(indexEvenMax);
                            }else{
                                System.out.println("No matches");
                            }
                            break;
                    }
                    break;
                case "min":
                    String typeMin = commands[1];
                    switch (typeMin){
                        case "odd":
                            int indexOddMin = findMinOddElementIndex(numbers);
                            if (indexOddMin >= 0){
                                System.out.println(indexOddMin);
                            }else{
                                System.out.println("No matches");
                            }
                            break;
                        case "even":
                            int indexEvenMin = findMinEvenElementIndex(numbers);
                            if (indexEvenMin >= 0){
                                System.out.println(indexEvenMin);
                            }else{
                                System.out.println("No matches");
                            }
                            break;
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(commands[1]);
                    String typeFirst = commands[2];
                    switch (typeFirst){
                        case "odd":
                            if (countFirst <= numbers.length) {
                                printFirstOddNumsCount(numbers, countFirst);
                            } else {
                                System.out.println("Invalid count");
                            }
                            break;
                        case "even":
                            if (countFirst <= numbers.length) {
                                printFirstEvenNumsCount(numbers, countFirst);
                            } else {
                                System.out.println("Invalid count");
                            }
                            break;
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(commands[1]);
                    String typeLast = commands[2];
                    switch (typeLast){
                        case "odd":
                            if (countLast <= numbers.length) {
                               printLastOddNumsCount(numbers, countLast);
                            } else {
                                System.out.println("Invalid count");
                            }
                            break;
                        case "even":
                            if (countLast <= numbers.length) {
                                printLastEvenNumsCount(numbers, countLast);
                            } else {
                                System.out.println("Invalid count");
                            }
                            break;
                    }
                    break;
            }
            input = scanner.nextLine().toLowerCase();
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void exchangeArray(int[]arr, int index){
        // [1,2,3, 4,5]
        // exchange 2 => [4,5, 1,2,3]
        int[]firstSide = new int[index + 1]; // [1,2,3] length 3
        int[]secondSide = new int[arr.length - (index + 1)]; // [4,5] length 2

        for (int i = 0; i < firstSide.length; i++) {
            firstSide[i] = arr[i]; // [1,2,3]
        }
        for (int i = index + 1; i < arr.length; i++) { // i = 3
            secondSide[i - (index + 1)] = arr[i]; // [4,5]      secondSide[0] = arr[3]
        }

        for (int i = 0; i < secondSide.length; i++) {
            arr[i] = secondSide[i]; // [4,5, 3,4,5]
        }
        for (int i = 0; i < firstSide.length; i++) {
            arr[i + secondSide.length] = firstSide[i]; // [4,5, 1,2,3]
        }

//        1 nested for loop
//        for (int i = 0; i <= index; i++) {
//            int firstElement = arr[0];
//            // shift left
//            for (int j = 0; j < arr.length - 1; j++) {
//                arr[j] = arr[j + 1];
//            }
//            //add first element to the last position
//            arr[arr.length - 1] = firstElement;
//        }

//        temp
//        int rotations = index + 1;
//        if (rotations >= arr.length){
//            rotations -= arr.length;
//        }
//
//        int count = 0;
//        while(count != rotations){
//            for (int i = 0; i < arr.length - 1; i++) { // move first el through all to the end !!!
//                int temp = arr[i + 1];
//                arr[i + 1] = arr [i];
//                arr[i] = temp;
//            }
//            count++;
//        }
    }

    private static int findMaxOddElementIndex(int[]arr){
        int maxElement = Integer.MIN_VALUE; // smallest possible value NOT 0, it's -2147483648
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] >= maxElement){
                maxElement = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMaxEvenElementIndex(int[]arr){
        int maxElement = Integer.MIN_VALUE; // smallest possible value NOT 0, it's -2147483648
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] >= maxElement){
                maxElement = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMinOddElementIndex(int[]arr){
        int minElement = Integer.MAX_VALUE; // smallest possible value NOT 0, it's -2147483648
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] <= minElement){
                minElement = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMinEvenElementIndex(int[]arr){
        int minElement = Integer.MAX_VALUE; // smallest possible value NOT 0, it's -2147483648
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] <= minElement){
                minElement = arr[i];
                index = i;
            }
        }
        return index;
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
}
