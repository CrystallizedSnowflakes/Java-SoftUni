package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E11ArrayManipulator02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] initialArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end"))
        {
            String message = "";
            switch (command[0])
            {
                case "exchange":
                    exchange(initialArray, command);
                    command = scanner.nextLine().split(" ");
                    continue;

                case "max":
                    int index = max(initialArray, command);
                    message = (index >= 0) ? String.valueOf(index) : "No matches";
                    break;

                case "min":
                    index = min(initialArray, command);
                    message = (index >= 0) ? String.valueOf(index) : "No matches";
                    break;

                case "first":
                    int count = Integer.parseInt(command[1]);
                    if (count > initialArray.length)
                    {
                        message = "Invalid count";
                        break;
                    }

                    String evenOrOdd = command[2];
                    String[] nums = first(initialArray, count, evenOrOdd);

                    message = Arrays.toString(nums);
                    break;

                case "last":
                    count = Integer.parseInt(command[1]);
                    if (count > initialArray.length)
                    {
                        message = "Invalid count";
                        break;
                    }

                    evenOrOdd = command[2];
                    nums = last(initialArray, count, evenOrOdd);
                    message = Arrays.toString(nums);
                    break;
            }

            System.out.println(message);
            command = scanner.nextLine().split(" ");
        }

        System.out.println(Arrays.toString(initialArray));
    }

    public static void exchange(int[] initialArray, String[] command){
        int index = Integer.parseInt(command[1]);
        if (index < 0 || index >= initialArray.length){
            System.out.println("Invalid index");
            return;
        }

        int[] leftSide = new int[index + 1];
        int[] rightSide = new int[initialArray.length - 1 - index];
        int counter = 0;

        for (int i = 0; i < initialArray.length; i++){
            if (i < leftSide.length){
                leftSide[i] = initialArray[i];
            }else{
                rightSide[counter] = initialArray[i];
                counter++;
            }
        }

        counter = 0;
        for (int i = 0; i < initialArray.length; i++){
            if (i < rightSide.length){
                initialArray[i] = rightSide[i];
            }else{
                initialArray[i] = leftSide[counter++];
            }
        }
    }

    public static int max(int[] initialArray, String[] command){
        int max = Integer.MIN_VALUE;
        int index = -1;

        switch (command[1]){
            case "even":
                for (int i = 0; i < initialArray.length; i++){
                    if (initialArray[i] % 2 == 0 && initialArray[i] >= max){
                        max = initialArray[i];
                        index = i;
                    }
                }
                break;

            case "odd":
                for (int i = 0; i < initialArray.length; i++){
                    if (initialArray[i] % 2 != 0 && initialArray[i] >= max){
                        max = initialArray[i];
                        index = i;
                    }
                }
                break;
        }
        return index;
    }

    public static int min(int[] initialArray, String[] command){
        int min = Integer.MAX_VALUE;
        int index = -1;
        switch (command[1]){
            case "even":
                for (int i = 0; i < initialArray.length; i++){
                    if (initialArray[i] % 2 == 0 && initialArray[i] <= min){
                        min = initialArray[i];
                        index = i;
                    }
                }
                break;

            case "odd":
                for (int i = 0; i < initialArray.length; i++){
                    if (initialArray[i] % 2 != 0 && initialArray[i] <= min){
                        min = initialArray[i];
                        index = i;
                    }
                }
                break;
        }
        return index;
    }

    public static String[] first(int[] initialArray, int count, String evenOrOdd)
    {
        String nums = "";
        switch (evenOrOdd){
            case "even":
                for(int digit : initialArray){
                if (count > 0 && digit % 2 == 0){
                    nums += String.format("%s", digit);
                    count--;
                }
            }
            break;

            case "odd":
                for(int digit : initialArray){
                if (count > 0 && digit % 2 != 0){
                    nums += String.format("%s", digit);
                    count--;
                }
            }
            break;
        }
        nums.trim();

        return nums.split("");
    }

    public static String[] last(int[] initialArray, int count, String evenOrOdd)
    {
        String nums = "";
        switch (evenOrOdd)
        {
            case "even":
                for (int i = initialArray.length - 1; i >= 0; i--)
                {
                    if (count > 0 && initialArray[i] % 2 == 0)
                    {
                        nums += String.format("%s", initialArray[i]);
                        count--;
                    }
                }
                break;

            case "odd":
                for (int i = initialArray.length - 1; i >= 0; i--)
                {
                    if (count > 0 && initialArray[i] % 2 != 0)
                    {
                        nums += String.format("%s", initialArray[i]);
                        count--;
                    }
                }
                break;
        }
        nums.trim();

        String[] numbers = nums.split("s+");

        for (int i = 0; i < numbers.length / 2; i++) {
            int swapIndex = numbers.length - 1 - i;
            String oldNumbersI = numbers[i];
            numbers[i] = numbers[swapIndex];
            numbers[swapIndex] = oldNumbersI;
        }

        return numbers;
    }
}
