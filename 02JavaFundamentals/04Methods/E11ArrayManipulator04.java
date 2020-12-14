package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E11ArrayManipulator04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String[] cmdArgs = command.split(" ");

            switch (cmdArgs[0]) {
                case "exchange":
                    int index = Integer.parseInt(cmdArgs[1]);
                    if (index >= 0 && index < number.length) {
                        exchange(number, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if (cmdArgs[1].equals("even")) {
                        int indexMax = findEvenIndex(number);
                        if (indexMax != -1) {
                            System.out.println(indexMax);
                        } else {
                            System.out.println("No matches");
                        }
                    } else {
                        int indexMax = findOddIndex(number);
                        if (indexMax != -1) {
                            System.out.println(indexMax);
                        } else {
                            System.out.println("No matches");
                        }
                    }
                    break;
                case "min":
                    if (cmdArgs[1].equals("even")) {
                        int indexMin = findMinEvenIndex(number);
                        if (indexMin != -1) {
                            System.out.println(indexMin);
                        } else {
                            System.out.println("No matches");
                        }
                    } else {
                        int indexMin = findMinOddIndex(number);
                        if (indexMin != -1) {
                            System.out.println(indexMin);
                        } else {
                            System.out.println("No matches");
                        }
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(cmdArgs[1]);
                    if (cmdArgs[2].equals("even")) {
                        if (countFirst <= number.length) {
                            printFirstEven(number, countFirst);
                        } else {
                            System.out.println("Invalid count");
                        }
                    } else {
                        int oddCount = Integer.parseInt(cmdArgs[1]);
                        if (oddCount <= number.length) {
                            printFirstOdd(number, countFirst);
                        } else {
                            System.out.println("Invalid count");
                        }
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(cmdArgs[1]);
                    if (cmdArgs[2].equals("even")) {
                        if (countLast <= number.length) {
                            printLastEven(number, countLast);
                        } else {
                            System.out.println("Invalid count");
                        }
                    } else {
                        int oddCount = Integer.parseInt(cmdArgs[1]);
                        if (oddCount <= number.length) {
                            printLastOdd(number, countLast);
                        } else {
                            System.out.println("Invalid count");
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        printArray(number);
    }

    private static void printLastEven(int[] number, int count) {
        int[] arr = new int[number.length];
        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] % 2 == 0 && count > 0) {
                count--;
                arr[i] = number[i];
            } else {
                arr[i] = -1;
            }
        }
        printArray(arr);
    }

    private static void printLastOdd(int[] number, int count) {
        int[] arr = new int[number.length];
        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] % 2 != 0 && count > 0) {
                count--;
                arr[i] = number[i];
            } else {
                arr[i] = -1;
            }
        }
        printArray(arr);
    }

    private static void printFirstOdd(int[] number, int count) {
        int[] arr = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 != 0 && count > 0) {
                count--;
                arr[i] = number[i];
            } else {
                arr[i] = -1;
            }
        }
        printArray(arr);
    }

    private static void printFirstEven(int[] number, int count) {
        int[] arr = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0 && count > 0) {
                count--;
                arr[i] = number[i];
            } else {
                arr[i] = -1;
            }
        }
        printArray(arr);
    }

    private static int findMinOddIndex(int[] number) {
        int index = -1;
        int maxNum = Integer.MAX_VALUE;
        for (int i = 0; i < number.length; i++) {
            if (maxNum >= number[i] && number[i] % 2 != 0) {
                maxNum = number[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMinEvenIndex(int[] number) {
        int index = -1;

        int maxNum = Integer.MAX_VALUE;

        for (int i = 0; i < number.length; i++) {
            if (maxNum >= number[i] && number[i] % 2 == 0) {
                maxNum = number[i];
                index = i;
            }
        }
        return index;
    }

    private static int findOddIndex(int[] number) {
        int index = -1;

        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < number.length; i++) {
            if (maxNum <= number[i] && number[i] % 2 != 0) {
                maxNum = number[i];
                index = i;
            }
        }
        return index;
    }

    private static int findEvenIndex(int[] number) {
        int index = -1;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < number.length; i++) {
            if (maxNum <= number[i] && number[i] % 2 == 0) {
                maxNum = number[i];
                index = i;
            }
        }
        return index;
    }

    private static void printArray(int[] number) {
        System.out.print("[");
        boolean printFirst = true;
        for (int i = 0; i < number.length; i++) {
            if (number[i] != -1) {
                if (printFirst) {

                    System.out.print(number[i]);
                    printFirst = false;
                } else {
                    System.out.print(", " + number[i]);
                }
            }
        }
        System.out.println("]");
    }

    private static void exchange(int[] number, int index) {

        int[] firstSide = new int[index + 1];
        int[] secondSide = new int[number.length - (index + 1)];

        for (int i = 0; i <= index; i++) {
            firstSide[i] = number[i];
        }

        for (int i = index + 1; i < number.length; i++) {
            secondSide[i - (index + 1)] = number[i];
        }

        for (int i = 0; i < secondSide.length; i++) {
            number[i] = secondSide[i];
        }

        for (int i = 0; i < firstSide.length; i++) {
            number[i + secondSide.length] = firstSide[i];
        }
    }
}
