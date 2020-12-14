package bg.softuni.javafundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class E09KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dnaLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine().toLowerCase();

        int[]bestDNA = new int[dnaLength];
        int bestSumSubSequenceOnes = 0;
        int bestSequenceIndex = 0;
        int bestSequenceSum = 0;
        int bestSample = 1;

        int currentSample = 0;
        while (!input.equals("clone them!")){
            int[]currentDNA = Arrays
                    .stream(input.split("!+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            int currentSumOnes = 0;
            int betterSumSubSequenceOnes = 0;
            int endIndex = 0;
            int currentSequenceSum = 0;
            currentSample++;
            for (int i = 0; i < currentDNA.length; i++) {
                if (currentDNA[i] == 1){
                    currentSequenceSum++;
                    currentSumOnes++;
                    if (currentSumOnes > betterSumSubSequenceOnes){
                        betterSumSubSequenceOnes = currentSumOnes;
                        endIndex = i;
                    }
                }else{
                    currentSumOnes = 0;
                }
            }

            int currentBestIndex = endIndex - (betterSumSubSequenceOnes - 1);

            boolean isDNABest = false;
            if (betterSumSubSequenceOnes > bestSumSubSequenceOnes){
                isDNABest = true;
            }else if(betterSumSubSequenceOnes == bestSumSubSequenceOnes ){
                if (currentBestIndex < bestSequenceIndex){
                    isDNABest = true;
                }else if(currentBestIndex == bestSequenceIndex){
                    if (currentSequenceSum > bestSequenceSum){
                        isDNABest = true;
                    }
                }
            }
            if (isDNABest){
                bestSumSubSequenceOnes = betterSumSubSequenceOnes;
                bestSequenceSum = currentSequenceSum;
                bestSequenceIndex = currentBestIndex;
                bestDNA = currentDNA;
                bestSample = currentSample;
            }
            input = scanner.nextLine().toLowerCase();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSample, bestSequenceSum);
        for (int i = 0; i < bestDNA.length; i++) {
            System.out.print(bestDNA[i] + " ");
        }
    }
}
