package bg.softuni.javaadvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class E07RecursiveFibonacciStack {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        // bottom -> up
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Long> stack = new ArrayDeque<>();

        stack.push(1L); // as long
        stack.push(1L);

        while (n-- > 1){
            long a = stack.pop();
            long b = stack.pop();
            long c = a + b;
            stack.push(b);
            stack.push(a);
            stack.push(c);
        }
        System.out.println(stack.pop());
    }
}
