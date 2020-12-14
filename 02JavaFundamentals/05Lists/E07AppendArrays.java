package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> strList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(strList);
        String str = strList.toString().replaceAll("[\\]\\[,]", "").trim();
        str = str.replaceAll("\\s+", " ");

        System.out.println(str);
    }
}
