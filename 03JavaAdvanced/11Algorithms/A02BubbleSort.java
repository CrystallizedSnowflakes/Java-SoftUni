package bg.softuni.javaadvanced;

public class A02BubbleSort {
    public static void main(String[] args) {

        // O(1) Complexity
        int[] arr = new int[] {77, 13, 10, 8, 6, 5, 4, 3, 2};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] > arr[j]){

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // 2 3 4 5 6 8 10 13 77
    }
}
