package jediGalaxy;

import java.util.Arrays;

public class InParser {
    // no instance needed => static
    public static int[] parseArray (String input, String pattern){
        return Arrays.stream(input.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
