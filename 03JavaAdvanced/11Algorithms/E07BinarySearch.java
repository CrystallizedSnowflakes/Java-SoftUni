package bg.softuni.javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

public class E07BinarySearch {
    public static void main (String[] args) {
        // yes Complexity O(log(n))
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray ();
        int key = Integer.parseInt(scanner.nextLine ());


        System.out.println(getIndex(array, key,0,array.length - 1));
    }

    private static int getIndex(int[] array, int key,int l, int r) {
        while (l <= r){
            int mid = (r + l) / 2;
            if (array[mid] > key){
                r = mid -1;
            }else if (array[mid] < key){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
