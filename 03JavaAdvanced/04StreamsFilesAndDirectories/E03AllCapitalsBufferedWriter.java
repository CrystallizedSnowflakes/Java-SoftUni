package bg.softuni.javaadvanced;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E03AllCapitalsBufferedWriter {
    public static void main(String[] args) throws IOException {
        // On January 1 , 1533 ,  -> ON JANUARY 1 , 1533 ,

        Path inputPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\input.txt");

        Path outputPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\output.txt");

        // reads a text file
        List<String> lines = Files.readAllLines(inputPath);  // readAllLines


        File outputFile = new File(String.valueOf(outputPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        //lines.forEach(line -> System.out.println(line.toUpperCase()));
        lines.forEach(line -> {
            try {
                writer.write(line.toUpperCase());
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.close();
    }
}
