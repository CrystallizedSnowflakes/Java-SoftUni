package bg.softuni.javaadvanced;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class E06WordCount {
    public static void main(String[] args) throws IOException {

        Path inputPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\words.txt");

        List<String> lines = Files.readAllLines(inputPath);
        LinkedHashMap<String, Integer> wordsCounter = new LinkedHashMap<>();

        for (String line : lines){
            String[] words = line.split("\\s+");

            for (String word : words) {
                word = word.replaceAll("[,.]", "");
                wordsCounter.put(word, 0);
            }
        }

        Path searchPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\text.txt");

        List<String> searchedLines = Files.readAllLines(searchPath);

        for (String line : searchedLines) {
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                if (wordsCounter.containsKey(word)){
                    wordsCounter.put(word, wordsCounter.get(word) + 1);
                }
            });
        }

        String outputPath = "C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src\\" +
                "04.Files-and-Streams-Exercises-Resources\\06results.txt";

        PrintWriter outputWriter = new PrintWriter(outputPath);
        wordsCounter.forEach((k, v) -> outputWriter.println(k + " - " + v));

        outputWriter.close();
    }
}
