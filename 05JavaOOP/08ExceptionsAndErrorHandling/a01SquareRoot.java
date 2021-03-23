import java.util.Scanner;

public class a01SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(Math.sqrt(Integer.parseInt(scanner.nextLine())));
        } catch (NumberFormatException ignored){
            System.out.println("Invalid number!");
        } finally {
            System.out.println("Good bye");
        }
    }
}
