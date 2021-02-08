package E03GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box();
        while (n-- > 0){
            String line = scanner.nextLine();
            box.add(line);
        }

        String[] indexes = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);

        box.swap(firstIndex, secondIndex);

        System.out.println(box);
    }
}
