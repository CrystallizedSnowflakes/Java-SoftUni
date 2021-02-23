package bg.softuni.javaadvanced;

public class Ex02SumArrMethodRecursive {
    public static void main(String[] args) {
        int[] arr = {13, 42, 69, 73};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        System.out.println(sumOfArrForward(arr, 0));
        System.out.println(sumOfArrBackward(arr, arr.length - 1));
    }

    public static int sumOfArrForward(int[]arr, int index){
        if (index == arr.length - 1){
            return arr[index];
        }
        return arr[index] + sumOfArrForward(arr, index + 1);
    }

    public static int sumOfArrBackward(int[]arr, int index){
        if (index == 0){
            return arr[index];
        }
        return arr[index] + sumOfArrBackward(arr, index - 1);
    }
}
