package a01RhombusOfStars;

import java.util.Scanner;

public class A01RhombusOfStarsMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getTriangleOfStars(n, true));
        System.out.println(getTriangleOfStars(n, false));
    }

    public static String repeatString(int count, String toReplace){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(toReplace);
        }
        return sb.toString();
    }

    public static String getTriangleOfStars(int n, boolean isUpwardsOriented){
        StringBuilder sb = new StringBuilder();

        for (int r = 1; r <= n; r++) {
            int spacesCount = isUpwardsOriented ? n - r : r;
            int starsCount = isUpwardsOriented ? r : n - r;
            sb.append(repeatString(spacesCount, " "));
            sb.append(repeatString(starsCount, "* "));
            if (r != n) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
