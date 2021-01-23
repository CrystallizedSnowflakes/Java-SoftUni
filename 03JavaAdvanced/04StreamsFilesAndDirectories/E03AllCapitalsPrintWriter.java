package bg.softuni.javaadvanced;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E03AllCapitalsPrintWriter {
    public static void main(String[] args) throws IOException {
        Path inputPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\input.txt");

        Path outputPath = Path.of("C:\\SoftUni\\03JavaAdvanced\\04StreamsFilesAndDirectories\\src" +
                "\\04.Files-and-Streams-Exercises-Resources\\output.txt");

        List<String> lines = Files.readAllLines(inputPath); // read

        File outputFile = new File(String.valueOf(outputPath));
        PrintWriter writer = new PrintWriter(outputFile);

        //lines.forEach(line -> System.out.println(line.toUpperCase()));
        lines.forEach(line -> writer.println(line.toUpperCase())); // write

        writer.close();
    }
}
