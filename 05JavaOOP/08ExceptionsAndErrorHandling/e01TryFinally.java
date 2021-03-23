import java.util.Scanner;

public class e01TryFinally {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        testTryFinally(sc);
    }

    static void testTryFinally(Scanner sc) {
        System.out.println("Code executed before try-finally.");
        try {
            String str = sc.nextLine(); // aaa OR 13
            Integer.parseInt(str);
            System.out.println("Parsing was successful.");
            return; // Exit from the current method
        } catch (NumberFormatException ex) {
            System.out.println("Parsing failed!");
        } finally {
            // always close the resource
            System.out.println("This cleanup code is always executed.");
        }
        System.out.println("This code is after the try-finally block.");
    }
}
