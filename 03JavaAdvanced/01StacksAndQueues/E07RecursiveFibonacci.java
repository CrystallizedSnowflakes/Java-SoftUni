package bg.softuni.javaadvanced;

import java.util.Scanner;

public class E07RecursiveFibonacci {
    // there is only zeroes [0,0,0] in this array
    public static long[] memoryForFib;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        memoryForFib = new long[ i + 1];
        long result = fib(i);
        System.out.println(result);
    }
    public static long fib(int i){
        // bottom
        //fib(0) = 1; fib(i - 1)
        //fib(1) = 1; fib(i - 2);
        if (i <= 1){
            return 1;
        }
        // if is != 0 there is something in
        if (memoryForFib[i] != 0){ // is empty / not in the memoryForFib
            // i is index
            return memoryForFib[i];
        }
        // adding
        // fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2);
        return memoryForFib[i] = fib(i - 1) + fib(i - 2);
                            // bottom   1               0
    }
}
