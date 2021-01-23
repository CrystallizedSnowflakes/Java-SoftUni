package bg.softuni.javaadvanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class E01SumLines {
    public static void main(String[] args) {
        // the sum of the ASCII symbols of each of its lines.
        //On January 1 , 1533 ,             -> 1452
        //Michael Angelo,                   -> 1397
        //then fifty-seven years old,       -> 2606
        //writes                            -> 670  | +
        //from Florence to                  -> 1573
        //Tommaso de' Cavalieri,            -> 2028
        //a youth of noble Roman family,    -> 2762
        //                                  -------- = 12488

        String inputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                            "\\04.Files-and-Streams-Exercises-Resources\\input.txt";

        File inputFile = new File(inputPath);
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputFile))){

        //try (BufferedReader inputReader = Files.newBufferedReader(Paths.get(inputPath))){

            String line = inputReader.readLine();
            while (line != null){
                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                line = inputReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
