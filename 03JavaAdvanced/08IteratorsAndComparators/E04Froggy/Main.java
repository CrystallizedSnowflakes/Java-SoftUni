package E04Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stones = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(stones);
        //Frog
        Iterator<Integer> froggy = lake.iterator();

        List<String> output = new ArrayList<>();
        while (froggy.hasNext()){
            output.add(froggy.next() + "");
        }

        System.out.println(String.join(", ", output));
    }
}
