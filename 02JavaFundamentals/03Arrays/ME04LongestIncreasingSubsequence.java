package bg.softuni.javafundamentals;

import java.util.*;

public class ME04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[]seq = Arrays
                .stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        //int[]seq = {7, 3, 5, 8, -1, 0, 6, 7};
        int[]len = new int[seq.length];
        int[]prev = new int[seq.length];

        int bestIndex = calculateLongestIncreasingSubsiquence(seq, len, prev);

        printLongestIncreasingSubsiquence(seq, prev, bestIndex);
    }

    private static int calculateLongestIncreasingSubsiquence(int[] seq, int[] len, int[] prev) {
        int maxIndex = 0;
        int maxLength = 0;
        for (int x = 0; x < seq.length; x++) {
            len[x] = 1;
            prev[x] = -1;
            for (int i = 0; i < x; i++) {
                if (seq[x] > seq[i] && len[i] + 1 > len[x]){
                    len[x] = len[i] + 1;
                    prev[x] = i;
                }
            }
            if (len[x] > maxLength){
                maxLength = len[x];
                maxIndex = x;
            }
        }
        return maxIndex;
    }

    private static void printLongestIncreasingSubsiquence(int[] seq, int[] prev, int index) {
        List<Integer> lis = new ArrayList<>();
        while (index != -1){
            lis.add(seq[index]);
            index = prev[index];
        }
        Collections.reverse(lis);

        for (int i = 0; i < lis.size(); i++) {
            System.out.print(lis.get(i) + " ");
        }
    }
}
