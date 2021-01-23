package bg.softuni.javaadvanced;

import java.io.*;

public class E04CountCharacterTypesLookUpTables {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\input.txt";

        String outputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\04CountCharacterTypesOutput.txt";

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        // lookUpTables
        String vowelsLookUpTable = "aoeui";
        String punctuationLookUpTable = "!,.?";


        BufferedReader inputReader = new BufferedReader(new FileReader(inputPath));
        String line = inputReader.readLine();
        while (line != null){     // until there in no writtenLine
            String[] words = line.split("\\s+");
            for (String word : words) {
                for (char symbol : word.toCharArray()){
                    String charAsString = String.valueOf(symbol);
                    if (vowelsLookUpTable.contains(charAsString)){
                        vowelsCount++;
                    } else if (punctuationLookUpTable.contains(charAsString)){
                        punctuationCount++;
                    } else {
                        consonantsCount++;
                    }
                }
            }
            line = inputReader.readLine();
        }
        inputReader.close();

        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputPath));
        outputWriter.write("Vowels: " + vowelsCount);
        outputWriter.newLine();
        outputWriter.write("Consonants: " + consonantsCount);
        outputWriter.newLine();
        outputWriter.write("Punctuation: " + punctuationCount);
        outputWriter.newLine();

        outputWriter.close();
    }
}
