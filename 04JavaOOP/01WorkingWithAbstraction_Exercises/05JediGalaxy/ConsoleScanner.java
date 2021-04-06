package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleScanner {
    // Field
    private Scanner sc;

    // Constructor
    public ConsoleScanner(){
        this.sc = new Scanner(System.in);
    }

    // Methods
    public String readLine(){
        return this.sc.nextLine();
    }

    public int[] readArray(){
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
