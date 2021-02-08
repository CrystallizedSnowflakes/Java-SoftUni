package E05GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        while (n-- > 0){
            String text = scanner.nextLine();
            box.add(text);
        }

        String elementForCompare = scanner.nextLine();

        int countGreater = box.countGreaterThan(elementForCompare);

        System.out.println(countGreater);
    }
}
