package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E05MergeSort {
    public static void main(String[] args) {
        // yes Complexity O(log(n)) memory is cheaper, we are optimizing the runtime
        // int[] arr = new int[] {77, 13, 10, 8, 6, 5, 4, 3, 2};

        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // 2 3 4 5 6 8 10 13 77
    }

    private static int[] mergeSort(int[] array){
        if (array.length == 1){
            return array;
        }

        int halfIndex = array.length / 2;
        int firstArrayLength = halfIndex;
        int secondArrayLength = array.length - halfIndex;

        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];

        for (int i = 0; i < firstArrayLength; i++) {
            firstPartition[i] = array[i];
        }

        for (int i = firstArrayLength; i < firstArrayLength + secondArrayLength; i++){
            secondPartition[i - firstArrayLength] = array[i];
        }

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);

        int mainIndex = 0;
        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < firstArrayLength && secondPartitionIndex < secondArrayLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex] = firstPartition[firstPartitionIndex];

                mainIndex++;
                firstPartitionIndex++;
            } else {
                array[mainIndex] = secondPartition[secondPartitionIndex];

                mainIndex++;
                secondPartitionIndex++;
            }

        }

        while (firstPartitionIndex<firstArrayLength){
            array[mainIndex] = firstPartition[firstPartitionIndex];
            mainIndex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex<secondArrayLength){
            array[mainIndex] = secondPartition[secondPartitionIndex];
            mainIndex++;
            secondPartitionIndex++;
        }

        return array;
    }
}
