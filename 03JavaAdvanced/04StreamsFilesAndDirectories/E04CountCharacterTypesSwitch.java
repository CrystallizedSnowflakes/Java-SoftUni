package bg.softuni.javaadvanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class E04CountCharacterTypesSwitch {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\input.txt";

        String outputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\04CountCharacterTypesOutput.txt";

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        BufferedReader inputReader = new BufferedReader(new FileReader(inputPath));
        String line = inputReader.readLine();
        while (line != null){     // until there in no writtenLine
            String[] words = line.split("\\s+");
            for (String word : words) {
                for (char symbol : word.toCharArray()){

                    switch(symbol){
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            vowelsCount++;
                            break;
                        case '!':
                        case ',':
                        case '.':
                        case '?':
                            punctuationCount++;
                        break;
                        default:
                            consonantsCount++;
                            break;
                    }
                }
            }
            line = inputReader.readLine();
        }
        inputReader.close();

        PrintWriter outputWriter = new PrintWriter(outputPath);
        outputWriter.printf("Vowels: %d%n", vowelsCount);
        outputWriter.printf("Consonants: %d%n", consonantsCount);
        outputWriter.printf("Punctuation: %d%n", punctuationCount);

        outputWriter.close();
    }
}
