package E04Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {

            int[] stones = Arrays.stream(input.split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Lake lake = new Lake(stones);

            StringBuilder sb = new StringBuilder();
            for (Integer n:lake) {
                sb.append(n).append(", ");
            }
            System.out.println(sb.substring(0, sb.lastIndexOf(",")));
            input = scanner.nextLine();
        }
    }
}
