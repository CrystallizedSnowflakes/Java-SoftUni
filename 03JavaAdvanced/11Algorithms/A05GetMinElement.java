package bg.softuni.javaadvanced;

public class A05GetMinElement {
    public static void main(String[] args) {
        int[] arr = new int[]{77, 13, 10, 8, 6, 5, 4, 3, 2};

        System.out.println(getMinElement(arr));
    }

    private static int getMinElement(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (Integer number : numbers) {
            if (number < min){
                min = number;
            }
        }
        return min;
    }
}
